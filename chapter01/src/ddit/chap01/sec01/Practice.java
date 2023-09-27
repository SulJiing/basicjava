package ddit.chap01.sec01;

import java.util.Random;
// 1. �ζ� ��ȣ�� �迭�� ����
// 2. �ζ� ��ȣ�� �����ִ� �޼ҵ� ����
// 3. �Է¹��� �ݾ����� �ζ� ��ȣ�� ���
import java.util.Scanner;

public class Practice {
	int[] lotto = new int[45];

	public static void main(String[] args) {
		new Practice().lotto();

	}

	public void lotto() {
		for (int i = 0; i < 45; i++) {
			lotto[i] = i + 1;
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("�ݾ��Է� : ");
		int money = sc.nextInt();

		for (int i = 0; i < money / 1000; i++) {
			shuffle();
			for (int j = 0; j < 6; j++) {
				System.out.println(lotto[j]);
			}
		}
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			int r = random.nextInt(45);
			int temp = r;
			r = lotto[1];
			lotto[1] = temp;
		}
	}
}