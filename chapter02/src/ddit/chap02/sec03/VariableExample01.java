package ddit.chap02.sec03;

import java.util.Scanner;

public class VariableExample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드입력값
		int v1 = 100;

		System.out.print("나이입력 : "); // 한줄만 인쇄하고 줄 바꾸지 않음 ln이붙으면 찍고 줄을 바꿈
		int age = sc.nextInt();

		if (age >= 18) {
			String message = "성년입니다.."; // 지역변수
			System.out.println(message);
		} else {
			String message = "미성년자 입니다.."; // 지역변수
			System.out.println(message);
		}

		System.out.println(age);
	}
}