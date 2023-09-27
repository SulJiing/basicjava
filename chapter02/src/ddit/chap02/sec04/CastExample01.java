package ddit.chap02.sec04;

import java.util.Scanner;

// 다음 3과목의 총점과 평균을 구하시오.(키보드로 입력) 단, 평균은 소수2번째 자리에서 반올림하시오
// 점수 : 97, 80, 90
// 키보드 입력
// 1.Scanner class import - 안해도 되는 것 - 2번 먼저하고 자동완성기능으로 써도 됨
//  → import java.util.Scanner; →자바폴더밑에 유틸폴더밑에 스캐너라는 클래스를 쓰겠다. → 선언문(class 밖에 기술)
// 2. Scanner class 객체를 생성
//  → Scanner sc(변수명임)=new Scanner(System.in);
// 3. 메세지 출력 - 입력받는 위치
//  → System.out.print("메세지");
// 4. Scanner 클래스 객체(sc)를 이용하여 자료 입력 
//   → (정수) sc.nextInt() - 공백이 나올때 까지의 숫자 120 130은 구별됨
//   →       Integer.parseInt(sc.nextLine()) - 엔터를 치기 전까지의 모든 데이터를 문자열로 받음
//   → (문자열) sc.next() 
//   →        sc.nextLine()
// 		→ 둘의 차이점 : next는 띄어쓰기가 있으면 뒤에 문자가 있더라도 출력하지 못함
public class CastExample01 {

	public static void main(String[] args) {
		int sum=0; //합 =0=초기화
		int score=0; //과목점수
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : "); //줄 안바뀜
		score=sc.nextInt();
		sum=sum+score; //0+입력받은데이터가 sum이 됨
		
		System.out.print("수학점수 : "); //줄 안바뀜
		score=sc.nextInt();
		sum=sum+score; //score 변수는 항상 최신의 값만 저장함
		
		System.out.print("과학점수 : "); //줄 안바뀜
		score=sc.nextInt();
	sum=sum+score;
		
//		System.out.print("next : ");
//		String str = sc.nextLine();
//		System.err.println(str + str);
//
//		System.out.print("next line : ");
//		String str1 = sc.nextLine();
//		System.err.println(str);
//		System.err.println(str1);

		double avg= (double) sum/3;
		avg=(int)(avg*10+0.5)/10.; // 둘째자리에서 반올림이기 때문에 10을 곱하고 0.5를 더한 것 그리고 10을 곱했기 때문에 10을 다시 나눠준 것
		// (int)를 붙힌 이유는 그 나머지 소수점 이하 자리를 떼어내기 위함
		//int는 정수이기 때문에 소수점 자리가 0으로 나옴 그래서 10뒤에 .을 찍거나 앞에 (double)를 붙혀야 함
		
		System.out.println("총점 ="+sum);
		
		
		System.out.println("평균 ="+avg);
	}

}
