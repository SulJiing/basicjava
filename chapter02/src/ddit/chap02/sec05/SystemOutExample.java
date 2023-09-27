package ddit.chap02.sec05;

public class SystemOutExample {

	public static void main(String[] args) {
	System.out.println("12345678901234567890");//모눈종이
	System.out.printf("%5d%6.2f\n", 10, 5.326);
	System.out.printf("%10s\n","대전시");//한글이라 밀린거
	System.out.printf("%-10s\n","대전시");
	System.out.printf("%10s\n","Daejeon"); //10까지 앞은 공백
	System.out.printf("%-10s\n","Daejeon");//-는 왼쪽 정렬
	

	System.out.print("대전시 ");
	System.out.print("중구 계룡로 846");
	}

}
