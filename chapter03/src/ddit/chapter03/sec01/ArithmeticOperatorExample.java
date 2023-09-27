package ddit.chapter03.sec01;

import java.util.Scanner;

// 4칙연산자 : +,-,x,/,%(나머지)
public class ArithmeticOperatorExample {

	public static void main(String[] args) { //coach class 재주는 곰이 부리고 사람이 받아간다.
		ArithmeticOperator ao=new ArithmeticOperator();
		//ao.arithmeticMethod01();			//오브젝트 클래스는 모든 클래스의 조상임
		ao.UnaryOperator();
		ao.ComparisonOperator();
		ao.ComparisonOperator2();
	}

}
   class ArithmeticOperator{ //workhorse class 일하는 클래스
	   Scanner sc=new Scanner(System.in);
	   void arithmeticMethod01() {
		// 4칙연산자 : +,-,x,/,%(나머지)
		   // 키보드로 정수 2개를 입력받아 덧셈,뺄셈,곱셈,나눗셈,나머지를 구하시오.
		   Scanner sc=new Scanner(System.in);
		   System.out.print("첫번째 정수 : ");
		   int num1 = sc.nextInt();
		   System.out.print("두번째 정수 : ");
		   int num2 = sc.nextInt();
		   
		   System.out.println(num1+"+"+num2+"="+(num1+num2));
		   System.out.println(num1+"-"+num2+"="+(num1-num2));
		   System.out.println(num1+"*"+num2+"="+(num1*num2));
		   System.out.println(num1+"/"+num2+"="+((double)num1/num2));
		   System.out.println(num1+"%"+num2+"="+(num1%num2));
		   

		   
	   }
	   void UnaryOperator() { // 이 메서드를 실행시키려면 메인메서드에서 ao.으로 실행시켜야 함
		   // 단항연산자 : 부호연산자(+,-), ~(1의 보수)=n의보수=더했을때0이되는수, !(not:논리부정), ++,--(증감연산자)
		   int age=30;
		   System.out.println(+50);
		   System.out.println(-50);
		   System.out.println(~50);
		   System.out.println(!(age>=80));
		   //++변수, 변수++ : 변수의 값을 1씩 증가
		   age++;
		   System.out.println("age = "+age);
		   ++age;
		   System.out.println("age = "+age);
		   //결과=변수++ : '변수'의 값을 '결과'에 저장하고 자신('변수')은 1증가
		   //결과=++변수 : '변수'의 값 즉, 자신('변수')이 1증가시키고 '결과'에 저장
		   // 초기화되지 않은 age값!
		   
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
		   System.out.println("총점 : "+sum);
		   }
	   
	   void ComparisonOperator() {
		   Scanner sc=new Scanner(System.in);
		   // 비교연산자 : >,<,==,<=,,>=,!=(<>)
		   // 결과가 참과 거짓 중 하나(true/false)
		   // 주로 조건문(if,while,?,for문 등) 구성에 사용됨
		   // 키보드로 점수를 입력받아 그 값이 60이상이면 'PASS', 그 미만이면 'FAIL'을 출력
		   
		   
		   System.out.print("점수 : ");
		   int score = sc.nextInt();
		   
		   if(score>=60) {
			   System.out.println("PASS");
		   }else {
			   System.out.println("FAIL");
		   }
		   System.out.println(score>=90);
 }
	   
	   void ComparisonOperator2() {
	   // 키보드로 년도를 입력받아 윤년과 평년을 구별하시오.
	   // 윤년:4의 배수이면서 100의 배수가 아닌 해 이거나  또는 400의 배수가 되는 해
	   //Scanner sc=new Scanner(System.in); 같은 클래스 안에 있을 때 한개만 멤버필드(클래스와메서드사이)에 두면 다 사용이 가능
		Scanner sc=new Scanner(System.in);
	   System.out.print("년도 : ");
	   int year=sc.nextInt();
	   if((year%4==0 && year%100!=0)||(year%400==0)) {
		   System.out.println(year+"년은 윤년입니다.");	   
	   }else {
		   System.out.println(year+"년은 평년입니다.");
	   }
	   }
   }