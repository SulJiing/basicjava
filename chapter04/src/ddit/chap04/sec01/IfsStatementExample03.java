package ddit.chap04.sec01;

import java.util.Random;
//08.18
import java.util.Scanner;

public class IfsStatementExample03 {
	Scanner sc = new Scanner(System.in); // ����ʵ�=Ŭ������� ���� �޼ҵ� ����

	public static void main(String[] args) { // static�� ���� �޼ҵ带 ���� �޼ҵ��� ��
		IfsStatementExample03 ist = new IfsStatementExample03();
		ist.ifMethod01();
		// ist.ifMethod02();
	}

	public void ifMethod01() {
		// Ű����� ������ �Է¹޾� �� ����
		// 100-96 : A+ 95-93 : A0 92-90: A- 89-86: B+ 85-83: b0 82-80: b-
		// �� ���ϴ� "Fail"�� ����Ͻÿ�
		System.out.print("�����Է� : ");
		int score = sc.nextInt();
		String grade = "";
		switch (score / 10) {
		case 10:
			grade = "A+";
			break;
		case 9:
			grade = "A";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
				grade += "0";
				break;
			case 6:
			case 7:
			case 8:
			case 9: // default �� ����
				grade += "+";
			}
			break; // 90���밡 �ѹ� �� ���������� ����
		case 8:
			grade = "B";
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				grade += "-";
				break;
			case 3:
			case 4:
			case 5:
				grade += "0";
				break;
			case 6:
			case 7:
			case 8:
			case 9:
				grade += "+";

			}
			break;
		default:
			grade = "Fail";
		}
		System.out.println(grade);
	}
	// if��
//		String grade = "";
//		System.out.print("�����Է� : ");
//		int score = sc.nextInt();
//		if (score > 89) {
//			grade = "A";
//			if (score > 95) {
//				grade = grade + "+";
//			} else if (score > 92) {
//				grade = grade + "0"; // = grade+="0";
//			} else {
//				grade += "-";
//			}
//		} else if (score > 79) {
//			grade = "B";
//			if (score > 85) {
//				grade = grade + "+";
//			} else if (score > 82) {
//				grade = grade + "0"; // = grade+="0";
//			} else {
//				grade += "-";
//			}
//		} else {
//			grade = "fail";
//		}
//		System.out.println(score + " => " + grade);
	// }

	public void ifMethod02() {
		// 1-100������ ������ ���� 2���� �����Ͽ� ũ������� (ū����������)
		// �����Ͻÿ�.(descending sort)
		Random r = new Random();
		int num1 = (int) (Math.random() * 100) + 1;
		int num2 = r.nextInt(100) + 1;
		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		System.out.println(num1 + ", " + num2);

	}
}
