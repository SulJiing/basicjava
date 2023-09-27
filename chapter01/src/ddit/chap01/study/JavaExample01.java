package ddit.chap01.study;

import java.lang.invoke.ForceInline;
import java.util.Scanner;

import javax.swing.ToolTipManager.insideTimerAction;

public class JavaExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JavaExample01 obj = new JavaExample01();
		// obj.test1();
		// obj.test4();
		// obj.test0();
		obj.test3();
	}

	public void test0() {
		System.out.print("입력 : ");
		int i = sc.nextInt();

		int min = i % 60;
		int hour = i / 60 % 24;
		int day = (i / 60) / 24;
		System.out.println(day + "일" + hour + "시간" + min);

	}

	public void test1() {
		int result = 0;
		int i = 100;

		while (result >= 0) {
			result += i;
		}
		System.out.println(result);
	}

	public void test2() {
		int ran = (int) (Math.random() * 2000) + 1;
		while (true) {
			System.out.println(ran + "분 남았습니다.");
			int input = sc.nextInt();
			System.out.println(input + "분이 경과 되었습니다.");
			System.out.println();
			ran = ran - input;
			if (ran < 0) {
				System.out.println("종료");
				break;
			}
			int day = ran / 60 / 24;
			int hour = (ran / 60) % 24;
			int min = ran % 60;
			System.out.println();
		}
	}

	public void test3() {
		int [][]bundle = new int [5][6];
		for(int line = 0; line<5; line++) {
			int lotto[];
			int lotto[] = new int[length]; 
		}
		int length = 6;
		int lotto[] = new int[length];

		for (int i = 0; i < length; i++) {
			int ran = (int) (Math.random() * 45) + 1;
			lotto[i] = ran;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j])
					i--;
				break;
			}
		}
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}bundle[]=
		
	}

	public void test4() {
		// 최대값 최소값
		int[] arr = { 10, 20, 30, 40, 50, 3, 60, -3 };
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if (max > arr[i]) {
				max = arr[i];
			}
			if (min < arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
