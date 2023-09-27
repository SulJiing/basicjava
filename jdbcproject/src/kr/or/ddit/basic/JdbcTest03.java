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
// 문제) LPROD_ID 값을 2개 입력받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 값 입력 :");
		int num1 = sc.nextInt();
		System.out.println();
		System.out.print("두 번째 값 입력 :");
		int num2 = sc.nextInt();
		
		// PreparedStatment 객체를 이용한 처리
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
			
//			// Statement 객체를 이용한 처리
//			String sql = "select * from lprod where lprod_id between "+min+" and "+max; //띄어쓰기 주의
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			---------------------------------------------------------------------------------------
//			PreparedStatment 객체를 이용한 처리
//			SQL문을 작성할 때 SQL문에 데이터가 들어갈 자리를 물음표(?)로 표시해서 작성한다.
			String sql = "select * from lprod where lprod_id >= ? and lprod_id <= ? ";
			
//			PreparedStatment 객체 생성 => 사용할 SQL문을 매개변수에 전달하여 작성
			pstmt = conn.prepareStatement(sql);
			
//			SQL문의 물음표(?)자리에 들어갈 데이터를 세팅
//			형식) PreparedStatment 객체.set자료형이름(물음표 번호, 세팅할 데이터);
			pstmt.setInt(1, num1);
			pstmt.setInt(2, num2);
			
//			데이터 세팅이 완료되면 SQL문을 실행
			rs = pstmt.executeQuery();
//			---------------------------------------------------------------------------------------
			System.out.println("쿼리문 결과");

			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID")); // 컬럼명은 대소문자 구분 없음
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