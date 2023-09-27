package kr.or.ddit.basic;
//09.06
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// LPROD���̺� ������ �����͸� �Է¹޾Ƽ� DB�� insert�ϴ� ����
public class JdbcTest04 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PC17", "java");
			System.out.println("�߰��� LPROD ������ �Է��ϼ���");
			System.out.print("LPROD_Id �� : ");
			int id = sc.nextInt();
			
			System.out.print("LPROD_gu �� : ");
			String gu = sc.next();
			
			System.out.print("LPROD_nm �� : ");
			String nm = sc.next();
			
//			// Statement ��ü�� �̿��� ó��
//			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "+
//			" values (" +id+ ", '" + gu + "', '"+nm+"')";
//			System.out.println("Ȯ�ο� sql => "+sql);
//			
//			stmt = conn.createStatement();
//			
//			// select���� ������ ���� executeQuery()�޼��带 ����ߴµ�
//			// select���� �ƴ� SQL���� ������ ���� executeUpdate()�޼��带 ����ؼ� ����
//			// executeUpdate() �޼����� ��ȯ�� ==> �۾��� ������ ���ڵ� ��
//			int cnt = stmt.executeUpdate(sql);
			
			//PreparedStatement ��ü�� �̿��� ó��
			
			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "+
					" values (?, ?, ?)"; //���ڿ��̶�� ''�ϸ� �ȵ�
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,gu);
			pstmt.setString(3,nm);
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("��ȯ�� cnt => "+ cnt);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
	}
}