package ddit.chap01.study.lotto;

import java.util.Scanner;

public class JavaMethod {

	public static void main(String[] args) {
		JavaVar jv = new JavaVar();
		JavaMethod jm = new JavaMethod();
//		jm.print();
//		jm.print("�׽�Ʈ");
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է����ּ��� :");
		int a = sc.nextInt();
		System.out.print("�����ڸ� �Է����ֻ��� :");
		String s = sc.next();
		System.out.print("�ι�° ���ڸ� �Է����ּ��� : ");
		int b = sc.nextInt();
		if(s.equals("*")) {
			System.out.println(jm.add2(a,b));
		}else if (s.equals("+")) {
			System.out.println(jm.add(a,b));
		}else if (s.equals("-")){
			System.out.println(jm.add1(a,b));
		}else if (s.equals("/")){
			System.out.println(jm.add3(a,b));
		}
//		int result=jm.add(3, 4);
//		System.out.println(result);
//		int result1=jm.add1(3, 4);
//		System.out.println(result1);
//		int result2=jm.add2(3, 4);
//		System.out.println(result2);
//		int result3=(int) jm.add3(3, 4);
//		System.out.println(result3);
//		jm.printAdd(10,8);
//		jm.printAdd();
	}
	public void print(String s, int num) {
		System.out.println(s+num);
	}
	
	public void print() {
		System.out.println("print �Դϴ�.");
	}
	public void print(String s) {
		System.out.println("���ڿ�"+s+"�� �Է¹��� print�Դϴ�.");
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	public int add1(int a, int b) {
		return a-b;
	}
	public int add2(int a, int b) {
		return a*b;
	}
	public double add3(int a, int b) {
		if(b==0); System.out.println("���� �� ����");
		return (double)a/b;
	}
	
	public int add() {
		JavaVar jv = new JavaVar();
		return jv.a+jv.b;
	}
	public void printAdd(int a, int b) {
		int i = add(a,b);
		System.out.println(i);
	}
	public void printAdd() {
		int j = add();
		System.out.println(j);
	}
}
class JavaVar{
	public int a = 3;
	public int b = 2;
	
}

