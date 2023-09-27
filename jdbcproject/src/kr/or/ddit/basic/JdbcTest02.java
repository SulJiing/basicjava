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
// 문제) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Lprod_id 값 입력 : ");
		int lprod_id = sc.nextInt();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PC17", "java");
			String sql = "select * from lprod where lprod_id > " + lprod_id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData result = rs.getMetaData();
			System.out.println("쿼리문 처리결과");
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
