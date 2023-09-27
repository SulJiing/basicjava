package ddit.chap01.sec01;

import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
		// 1-2+3-4+5-6+7-8+9-10
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				sum1 += i;
			} else if (i % 2 == 0) {
				sum2 += i;

			}

		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum1 - sum2);
	}
}

//		while(true) {
//			int num1 = (int)(Math.random()*6)+1;
//			int num2 = (int)(Math.random()*6)+1;
//			 System.out.println("("+num1+num2+")");
//			 if(num1+num2 == 5);{
//					break;
//				}
//		}
//		
//	
//		
//	
//		for (int x = 1; x <= 10; x++) {
//			for (int y = 1; y<=10; y++) {
//			if((4*x+5*y)==60) {
//				System.out.println("("+x+","+y+")");
//			}
//			}
//		}
//		

//for (int i = 1; i<5; i++) {
//	for (int z = 4; z > 0; z--) {
//		System.out.print("*");
//		if(z==i) {
//			System.out.println();
//		}
//	}
//}
//Scanner sc = new Scanner(System.in);
//System.out.println("----------------------------");
//System.out.println("1.예금 2.출금 3.잔고 4.종료");
//System.out.println("----------------------------");
//System.out.println("선택> ");
//int choice = sc.nextInt();
//if (choice==1) {
//System.out.println("예금액> ");
//} else if (choice==2){ 
//System.out.println("출금액> ");
//} else if (choice==3){ 
//System.out.println("잔고> ");
//} else { 
//	System.out.println("프로그램 종료");
//}
//}
//	
//}
