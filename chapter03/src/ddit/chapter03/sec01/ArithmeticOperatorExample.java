package ddit.chapter03.sec01;

import java.util.Scanner;

// 4Ģ������ : +,-,x,/,%(������)
public class ArithmeticOperatorExample {

	public static void main(String[] args) { //coach class ���ִ� ���� �θ��� ����� �޾ư���.
		ArithmeticOperator ao=new ArithmeticOperator();
		//ao.arithmeticMethod01();			//������Ʈ Ŭ������ ��� Ŭ������ ������
		ao.UnaryOperator();
		ao.ComparisonOperator();
		ao.ComparisonOperator2();
	}

}
   class ArithmeticOperator{ //workhorse class ���ϴ� Ŭ����
	   Scanner sc=new Scanner(System.in);
	   void arithmeticMethod01() {
		// 4Ģ������ : +,-,x,/,%(������)
		   // Ű����� ���� 2���� �Է¹޾� ����,����,����,������,�������� ���Ͻÿ�.
		   Scanner sc=new Scanner(System.in);
		   System.out.print("ù��° ���� : ");
		   int num1 = sc.nextInt();
		   System.out.print("�ι�° ���� : ");
		   int num2 = sc.nextInt();
		   
		   System.out.println(num1+"+"+num2+"="+(num1+num2));
		   System.out.println(num1+"-"+num2+"="+(num1-num2));
		   System.out.println(num1+"*"+num2+"="+(num1*num2));
		   System.out.println(num1+"/"+num2+"="+((double)num1/num2));
		   System.out.println(num1+"%"+num2+"="+(num1%num2));
		   

		   
	   }
	   void UnaryOperator() { // �� �޼��带 �����Ű���� ���θ޼��忡�� ao.���� ������Ѿ� ��
		   // ���׿����� : ��ȣ������(+,-), ~(1�� ����)=n�Ǻ���=��������0�̵Ǵ¼�, !(not:������), ++,--(����������)
		   int age=30;
		   System.out.println(+50);
		   System.out.println(-50);
		   System.out.println(~50);
		   System.out.println(!(age>=80));
		   //++����, ����++ : ������ ���� 1�� ����
		   age++;
		   System.out.println("age = "+age);
		   ++age;
		   System.out.println("age = "+age);
		   //���=����++ : '����'�� ���� '���'�� �����ϰ� �ڽ�('����')�� 1����
		   //���=++���� : '����'�� �� ��, �ڽ�('����')�� 1������Ű�� '���'�� ����
		   // �ʱ�ȭ���� ���� age��!
		   
		   age=30;
		   System.out.println("postfix = "+(age++));
		   System.out.println(age);
		   
		   age=30;
		   System.out.println("prefix : "+(++age));
		   System.out.println(age);
		   
		   int[] score= {95,70,85,90,60};
		    int sum=0;
		   for(int i=0; i<score.length;) {
			   sum=sum+score[i];
		   }
		   System.out.println("���� : "+sum);
		   }
	   
	   void ComparisonOperator() {
		   Scanner sc=new Scanner(System.in);
		   // �񱳿����� : >,<,==,<=,,>=,!=(<>)
		   // ����� ���� ���� �� �ϳ�(true/false)
		   // �ַ� ���ǹ�(if,while,?,for�� ��) ������ ����
		   // Ű����� ������ �Է¹޾� �� ���� 60�̻��̸� 'PASS', �� �̸��̸� 'FAIL'�� ���
		   
		   
		   System.out.print("���� : ");
		   int score = sc.nextInt();
		   
		   if(score>=60) {
			   System.out.println("PASS");
		   }else {
			   System.out.println("FAIL");
		   }
		   System.out.println(score>=90);
 }
	   
	   void ComparisonOperator2() {
	   // Ű����� �⵵�� �Է¹޾� ����� ����� �����Ͻÿ�.
	   // ����:4�� ����̸鼭 100�� ����� �ƴ� �� �̰ų�  �Ǵ� 400�� ����� �Ǵ� ��
	   //Scanner sc=new Scanner(System.in); ���� Ŭ���� �ȿ� ���� �� �Ѱ��� ����ʵ�(Ŭ�����͸޼������)�� �θ� �� ����� ����
		Scanner sc=new Scanner(System.in);
	   System.out.print("�⵵ : ");
	   int year=sc.nextInt();
	   if((year%4==0 && year%100!=0)||(year%400==0)) {
		   System.out.println(year+"���� �����Դϴ�.");	   
	   }else {
		   System.out.println(year+"���� ����Դϴ�.");
	   }
	   }
   }