package ddit.chap01.study;

import java.util.Scanner;

public class StudyFor {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// study01();
		// study02();
		//study03();
		study04();

	}

	// 입력받은 값을 구구단으로 출력하시오
	public static void study01() {
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.print(dan + "*" + i + "=" + (dan * i));
			System.out.println();
		}
	}

	public static void study02() {
		// 모든 구구단 출력
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d =  %2d\t", j, i, i * j);
			}
			System.out.println();
		}
	}

	public static void study03() {
		// 입력한 단을 제외한 구구단은 출력
		System.out.print("제외할 단 입력 : ");
		int dan = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (dan == j) {
					j++;
				}
				System.out.printf("%d * %d =  %2d\t", j, i, i * j);
			}
			System.out.println();
		}
	}
	public static void study04() {
		// 소문자 대문자 변환
		String test = "dAd";
		int a = 'a'-'A';
		System.out.println(a);
		char c[] = test.toCharArray();
		for(char c : sc.toCharArray()) {
			if
			
		}
	}
	
}











