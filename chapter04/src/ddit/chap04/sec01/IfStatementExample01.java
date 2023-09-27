package ddit.chap04.sec01;

import java.util.Scanner;

// if문 08.17
public class IfStatementExample01 {
 static Scanner sc = new Scanner(System.in); // 여러 메소드에서 동시에 쓰겠다. 그러면 앞에 Static을 붙이면 됨
	public static void main(String[] args) {
		//ifMethod01();
		//ifMethod02();
		ifMethod03();
	}

	
	public static void ifMethod01() {
		// 키보드로 점수를 입력받아 60점 이상이면 "합격"을 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("점수입력 : ");
		int score = sc.nextInt();
		if (score>=60) {
			System.out.println("합격");
		} 
	}

	public static void ifMethod02() {
		// 정수 하나를 입력받아 홀수인지 짝수인지 판별하시오
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		if (num%2==0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
	}
	}
	
	public static void ifMethod03() {
	// 키보드로 1~12 사이의 정수를 입력받아 그 값이 3~5이면 "봄 입니다" 6~8이면 "여름 입니다" 9~11이면 "가을 입니다" 12,1,2이면 "겨울 입니다"
	// 를 출력하시오
	System.out.print("월 입력(1~12) : ");
	int month = sc.nextInt();
	String message="";
	if (month < 1 || month > 12) {
		System.out.println("월을 잘못 입력했습니다");
		System.exit(0);
	}
	if (month>=3 && month<=5) {
		message = month + "은 봄 입니다";
	} else if (month>=6 && month<=8) {
		message = month + "월은 여름 입니다";
	} else if (month>=9 && month<=11) {
		message = month + "월은 가을 입니다";
	}	else {
		message = month + "월은 겨을 입니다";
	}
	System.out.println(message);
	
	}
}
	
