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

	// �Է¹��� ���� ���������� ����Ͻÿ�
	public static void study01() {
		System.out.print("�� �Է� : ");
		int dan = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.print(dan + "*" + i + "=" + (dan * i));
			System.out.println();
		}
	}

	public static void study02() {
		// ��� ������ ���
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d =  %2d\t", j, i, i * j);
			}
			System.out.println();
		}
	}

	public static void study03() {
		// �Է��� ���� ������ �������� ���
		System.out.print("������ �� �Է� : ");
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
		// �ҹ��� �빮�� ��ȯ
		String test = "dAd";
		int a = 'a'-'A';
		System.out.println(a);
		char c[] = test.toCharArray();
		for(char c : sc.toCharArray()) {
			if
			
		}
	}
	
}











