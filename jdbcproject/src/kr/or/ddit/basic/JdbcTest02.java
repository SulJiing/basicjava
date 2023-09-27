package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 09.06
public class JdbcTest02 {
// ����) ����ڷκ��� Lprod_id���� �Է¹޾� �Է��� ������ lprod_id�� ū �ڷ���� ����Ͻÿ�.
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Lprod_id �� �Է� : ");
		int lprod_id = sc.nextInt();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PC17", "java");
			String sql = "select * from lprod where lprod_id > " + lprod_id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData result = rs.getMetaData();
			System.out.println("������ ó�����");
			while (rs.next()) {
				for(int i =1; i<result.getColumnCount()+1; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (stmt != null)try {stmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}

}
