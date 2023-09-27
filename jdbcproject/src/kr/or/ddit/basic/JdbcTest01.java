package kr.or.ddit.basic;
//09.06
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC(Java DataBase Connectivity) : ���̺귯���� �̿��� DB�ڷḦ ó���ϴ� ����
public class JdbcTest01 {
	/* DBó�� ����
	 * 1. ����̹� �ε� => ���̺귯���� ����� �� �ְ� �޸𸮷� �о� ���̴� �۾�
	 * - Class.forName("oracle.jdbc.driver.OracleDriver");	
	 * => JDBC ���� 4.0 �̻󿡼��� getConnerction() �޼��忡�� �ڵ����� �ε��� ���� => ��������(������ �������� �ʰ� ����� ����)
	 * 2. DB�ý��ۿ� �����ϱ� => ������ �Ϸ�Ǹ� Connection ��ü�� ��ȯ��
	 * - DriverManager.getConnection() �޼��带 �̿�
	 * 3. �����۾� => SQL������ DB������ ������ ����� ����
	 * - (Statement ��ü �Ǵ� PreparedStatment ��ü�� �̿��Ͽ� �۾�)
	 * 4. ���ó�� �۾�
	 * 	1) SQL�� select���� ��쿡�� select�� ����� ResultSet ��ü�� ����Ǿ� ��ȯ
	 * 	2) SQL�� select���� �ƴ� ���(insert��, delete��, update��)���� �������� ��ȯ(�� �������� ���� ���࿡ ������ ���ڵ� ���� �ǹ�)
	 * 5. ����� �ڿ��ݳ� => �� ��ü�� close() �޼��带 �̿�
	 */
	
	public static void main(String[] args) {
		// DB �۾��� �ʿ��� ���� ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB����
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "PC17", "java");
			
			// 3. ����
			// 3-1. SQL�� �ۼ�
			String sql = "select * from lprod";
			
			// 3-2. Statement ��ü���� => ���Ǹ� ó���ϴ� ��ü
			stmt = conn.createStatement();
			
			// 3-3. SQL���� DB������ �����ϰ� DB������ ó���� ����� ����
			// 		(������ ������ SQL���� select���̱� ������ ����� ResultSet�� ����Ǿ� ��ȯ��)
			rs = stmt.executeQuery(sql);
			
			// 4. ���ó�� => �� ���ڵ徿 ȭ�鿡 ����ϱ�
			// ResultSet�� ����� ����Ʈ�� ���ʷ� ���� ������ �ݺ����� next() �޼��带 ����ؼ� ó��
			System.out.println(" == ������ ó�� ��� == ");
			
			// rs.next() �޼��� => re ��ü�� �����͸� ����Ű�� �����͸� ������° ���ڵ� ��ġ�� �̵���Ű�� 
			// �� ���� �����Ͱ� ������ true, �׷��� ������ false�� ��ȯ
			while(rs.next()) {
				// �����Ͱ� ����Ű�� ���� �ڷḦ �������� ���
				// ����1) rs.get�ڷ����̸�("�÷��� �Ǵ� alias��")
				// ����2) rs.get�ڷ����̸�(�÷���ȣ) => �÷���ȣ�� 1���� ����/�ε����� �ٸ�
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID")); //�÷����� ��ҹ��� ���� ����
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString("lprod_nm"));
				System.out.println("--------------------------------------");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. �ڿ��ݳ�
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}

	}
}