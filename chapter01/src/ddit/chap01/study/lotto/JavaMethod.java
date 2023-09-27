package ddit.chap01.study.lotto;

import java.util.Scanner;

public class JavaMethod {

	public static void main(String[] args) {
		JavaVar jv = new JavaVar();
		JavaMethod jm = new JavaMethod();
//		jm.print();
//		jm.print("테스트");
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력해주세요 :");
		int a = sc.nextInt();
		System.out.print("연산자를 입력해주새요 :");
		String s = sc.next();
		System.out.print("두번째 숫자를 입력해주세요 : ");
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
		System.out.println("print 입니다.");
	}
	public void print(String s) {
		System.out.println("문자열"+s+"를 입력받은 print입니다.");
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
		if(b==0); System.out.println("나눌 수 없쪙");
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

