package ddit.chater05.sec02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 08.24
public class ArrayExample02 {
	int[] lotto = new int[45]; // 45���� ���� ������ ������
	Random r = new Random(); // �� �ڸ��� ��� �ڸ������� ����� �� �ְԵ�

	public static void main(String[] args) {
		// �ζǹ�ȣ ����
		new ArrayExample02().lotto(); // �ڱ� Ŭ���� ��ü�� �����ϸ� ����ƽ�� �� �ᵵ ��
	}

	public void lotto() {

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1; // ù °�� �����ϴ� ���� 0�̱� ������ 1�� �����ִ� ��

		}
		// System.out.println(Arrays.toString(lotto));
		// (�׽�Ʈ) �迭�� ������ִ� Ŭ���� (Arrays=Ŭ����, toString=����ƽ)

		// 1000�� ��ġ �ζ� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("�ݾ� : ");
		int money = sc.nextInt();

		for (int i = 1; i <= money / 1000; i++) {
			shuffle();
			System.out.print(i+":");
			for (int j = 0; j < 6; j++) { // 6�ڸ��� �̱� ���� for��
				System.out.printf("%5d", lotto[j]);
			}
			System.out.println();
		}

	}

	public void shuffle() {
		// �迭��Ҹ� ����
		for (int i = 0; i < 1000000; i++) {
			int rnd = r.nextInt(45); // 45�� ���Ե��� ����, 0~44������ ���� �迭��Ұ� �ƴ϶� �ε��� ����
			int temp = lotto[0];
			lotto[0] = lotto[rnd];
			lotto[rnd] = temp; // ���� �ٲٱ�
		}

	}
}
