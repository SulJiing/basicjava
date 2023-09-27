package ddit.chap04.sec02;

import java.util.Scanner;

//08.18
public class ForStatementExample01 {

	public static void main(String[] args) {
		// forMethod01();
		// forMethod02();
		forMethod03();

	}

	public static void forMethod01() {
		// 1부터 10까지 한칸 공백을 삽입하여 출력하시오
		int i = 0;
		for (i = 0; i < 10; i++) {
			System.out.printf("%-2d", i + 1); // 2칸의 공백을 만들어 -왼쪽 정렬
		}

	}

	public static void forMethod02() {
		// 1-100 사이의 짝수와 홀수의 합을 구하시오
		int even = 0; // 짝수의 합
		int odd = 0; // 홀수의 합
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				even = even + i;
			} else {
				odd += i;
			}
		}
		System.out.println("even = " + even);
		System.out.println("odd = " + odd);
	}

	public static void forMethod03() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2~9사이의 정수 입력 : ");
		int dan = sc.nextInt();// 구구단의 단을 입력
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}

	}
}
