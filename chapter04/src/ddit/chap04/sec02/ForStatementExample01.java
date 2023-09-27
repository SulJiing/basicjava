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
		// 1���� 10���� ��ĭ ������ �����Ͽ� ����Ͻÿ�
		int i = 0;
		for (i = 0; i < 10; i++) {
			System.out.printf("%-2d", i + 1); // 2ĭ�� ������ ����� -���� ����
		}

	}

	public static void forMethod02() {
		// 1-100 ������ ¦���� Ȧ���� ���� ���Ͻÿ�
		int even = 0; // ¦���� ��
		int odd = 0; // Ȧ���� ��
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
		System.out.print("2~9������ ���� �Է� : ");
		int dan = sc.nextInt();// �������� ���� �Է�
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}

	}
}
