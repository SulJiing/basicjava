package ddit.chap04.sec01;

import java.util.Scanner;

// if�� 08.17
public class IfStatementExample01 {
 static Scanner sc = new Scanner(System.in); // ���� �޼ҵ忡�� ���ÿ� ���ڴ�. �׷��� �տ� Static�� ���̸� ��
	public static void main(String[] args) {
		//ifMethod01();
		//ifMethod02();
		ifMethod03();
	}

	
	public static void ifMethod01() {
		// Ű����� ������ �Է¹޾� 60�� �̻��̸� "�հ�"�� ����Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
		int score = sc.nextInt();
		if (score>=60) {
			System.out.println("�հ�");
		} 
	}

	public static void ifMethod02() {
		// ���� �ϳ��� �Է¹޾� Ȧ������ ¦������ �Ǻ��Ͻÿ�
		System.out.print("�����Է� : ");
		int num = sc.nextInt();
		if (num%2==0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
	}
	}
	
	public static void ifMethod03() {
	// Ű����� 1~12 ������ ������ �Է¹޾� �� ���� 3~5�̸� "�� �Դϴ�" 6~8�̸� "���� �Դϴ�" 9~11�̸� "���� �Դϴ�" 12,1,2�̸� "�ܿ� �Դϴ�"
	// �� ����Ͻÿ�
	System.out.print("�� �Է�(1~12) : ");
	int month = sc.nextInt();
	String message="";
	if (month < 1 || month > 12) {
		System.out.println("���� �߸� �Է��߽��ϴ�");
		System.exit(0);
	}
	if (month>=3 && month<=5) {
		message = month + "�� �� �Դϴ�";
	} else if (month>=6 && month<=8) {
		message = month + "���� ���� �Դϴ�";
	} else if (month>=9 && month<=11) {
		message = month + "���� ���� �Դϴ�";
	}	else {
		message = month + "���� ���� �Դϴ�";
	}
	System.out.println(message);
	
	}
}
	
