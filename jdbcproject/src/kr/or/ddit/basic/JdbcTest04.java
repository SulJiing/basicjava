package kr.or.ddit.basic;
//09.06
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// LPROD테이블에 저장할 데이터를 입력받아서 DB에 insert하는 예제
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
			System.out.println("추가할 LPROD 정보를 입력하세요");
			System.out.print("LPROD_Id 값 : ");
			int id = sc.nextInt();
			
			System.out.print("LPROD_gu 값 : ");
			String gu = sc.next();
			
			System.out.print("LPROD_nm 값 : ");
			String nm = sc.next();
			
//			// Statement 객체를 이용한 처리
//			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "+
//			" values (" +id+ ", '" + gu + "', '"+nm+"')";
//			System.out.println("확인용 sql => "+sql);
//			
//			stmt = conn.createStatement();
//			
//			// select문을 실행할 때는 executeQuery()메서드를 사용했는데
//			// select문이 아닌 SQL문을 실행할 때는 executeUpdate()메서드를 사용해서 실행
//			// executeUpdate() 메서드의 반환값 ==> 작업에 성공한 레코드 수
//			int cnt = stmt.executeUpdate(sql);
			
			//PreparedStatement 객체를 이용한 처리
			
			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "+
					" values (?, ?, ?)"; //문자열이라고 ''하면 안됨
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,gu);
			pstmt.setString(3,nm);
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("반환값 cnt => "+ cnt);
				
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