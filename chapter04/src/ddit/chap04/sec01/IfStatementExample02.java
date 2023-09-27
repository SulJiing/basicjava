package ddit.chap04.sec01;

import java.util.Scanner;

// if 02 08.17
public class IfStatementExample02 {

	public static void main(String[] args) {
		// Ű�� ü���� ���� m�� kg���� �Է¹޾� BMI������ ����ϰ�
		// ���� BMI ������ 0 ~ 18.4 : ��ü�� / 18.5 ~ 22.9 : ����ü��
		// 23.0 ~ 24.9 : ��ü�� / 25.0 ~ 29.9 : �� / 30.0 �̻� : ���� �� ����Ͻÿ�
		// BMI ���� = ü��(kg) / (Ű(m) * Ű(m))
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű �Է� (m) : ");
		double m = sc.nextDouble();
		System.out.print("ü�� �Է� (kg) : ");
		double kg = sc.nextDouble();

		// double changeMitter = (double) m / 100;
		// double bmi = kg / (changeMitter * changeMitter);
		// System.err.printf("%.1f\n", bmi);
		// - %.1f ���� �Ҽ��� �ڸ������� �ݿø�
		double bmi = kg / (m * m);
		bmi = (int) (bmi * 10 + 0.5) / 10.;
		// ��°�ڸ����� �ݿø��̱� ������ 10�� ���ϰ� 0.5�� ���� �� �׸��� 10�� ���߱� ������ 10�� �ٽ� ������ ��
		// (int)�� ���� ������ �� ������ �Ҽ��� ���� �ڸ��� ����� ����
		// int�� �����̱� ������ �Ҽ��� �ڸ��� 0���� ���� �׷��� 10�ڿ� .�� ��ų� �տ� (double)�� ������ ��
		System.out.println("BMI���� : " + bmi);
		String message = "";
		if (bmi < 18.5) {
			message = "��ü��";
		} else if (bmi < 23.0) {
			message = "����ü��";
		} else if (bmi < 25.0) {
			message = "��ü��";
		} else if (bmi < 30.0) {
			message = "��";
		} else if (bmi >= 30.0) {
			message = "����";
		}
		System.out.println("Ű " + m + "m�� ü��" + kg + "kg��" + message + "�Դϴ�.\nBMI ������" + bmi + " �Դϴ�.");
		System.out.printf("BMI ���� : %.1f", bmi);
	}
}
