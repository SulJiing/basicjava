package ddit.chap01.study;

import java.util.Scanner;

public class JavaExample00 {

	public static void main(String[] args) {
		JavaExample00 obj = new JavaExample00();
		obj.test1();
		if (1 == 1) {
			System.out.println("DDD");

		}
		String str = new String();
	}

	public void test1() {
		// �� �⺻Ÿ���� ����� �����غ�����
//		byte b = 0; // byte�� ���� �迭������ ����� (�׸� ��)
//		short s = 0;
//		int i = 0;
//		long l = 0l;
//		char c = 'a';
//		float f = 0f;
//		double d = 0.0;
//		boolean o = true;
//		String str = "";
		char c1 = 'a';
		int i1;
		i1 = c1;

		int i2 = 65;
		char c2;
		c2 = (char) i2;

		int a = 3;
		int b = 7;
		double d3;
		d3 = (double) a / b;

		char c4 = 'a';
		String s4;
		s4 = c4 + "";

		String s5 = "a";
		char[] c5;
		c5 = s5.toCharArray();

	}
}