package ddit.chap02.sec03;

import java.util.Scanner;

public class VariableExample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Ű�����Է°�
		int v1 = 100;

		System.out.print("�����Է� : "); // ���ٸ� �μ��ϰ� �� �ٲ��� ���� ln�̺����� ��� ���� �ٲ�
		int age = sc.nextInt();

		if (age >= 18) {
			String message = "�����Դϴ�.."; // ��������
			System.out.println(message);
		} else {
			String message = "�̼����� �Դϴ�.."; // ��������
			System.out.println(message);
		}

		System.out.println(age);
	}
}