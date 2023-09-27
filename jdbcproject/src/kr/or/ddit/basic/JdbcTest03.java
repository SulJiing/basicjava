package kr.or.ddit.basic;
//09.06

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest03 {
// ����) LPROD_ID ���� 2�� �Է¹޾Ƽ� �� �� �� ���� ������ ū �� ������ �ڷ���� ����Ͻÿ�.
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° �� �Է� :");
		int num1 = sc.nextInt();
		System.out.println();
		System.out.print("�� ��° �� �Է� :");
		int num2 = sc.nextInt();
		
		// PreparedStatment ��ü�� �̿��� ó��
		if(num1>num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PC17", "java");
			
//			// Statement ��ü�� �̿��� ó��
//			String sql = "select * from lprod where lprod_id between "+min+" and "+max; //���� ����
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			---------------------------------------------------------------------------------------
//			PreparedStatment ��ü�� �̿��� ó��
//			SQL���� �ۼ��� �� SQL���� �����Ͱ� �� �ڸ��� ����ǥ(?)�� ǥ���ؼ� �ۼ��Ѵ�.
			String sql = "select * from lprod where lprod_id >= ? and lprod_id <= ? ";
			
//			PreparedStatment ��ü ���� => ����� SQL���� �Ű������� �����Ͽ� �ۼ�
			pstmt = conn.prepareStatement(sql);
			
//			SQL���� ����ǥ(?)�ڸ��� �� �����͸� ����
//			����) PreparedStatment ��ü.set�ڷ����̸�(����ǥ ��ȣ, ������ ������);
			pstmt.setInt(1, num1);
			pstmt.setInt(2, num2);
			
//			������ ������ �Ϸ�Ǹ� SQL���� ����
			rs = pstmt.executeQuery();
//			---------------------------------------------------------------------------------------
			System.out.println("������ ���");

			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID")); // �÷����� ��ҹ��� ���� ����
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString("lprod_nm"));
				System.out.println("--------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (rs != null)try {rs.close();} catch (SQLException e) {}
			if (stmt != null)try {stmt.close();} catch (SQLException e) {}
			if (conn != null)try {conn.close();} catch (SQLException e) {}
		}
	}
}