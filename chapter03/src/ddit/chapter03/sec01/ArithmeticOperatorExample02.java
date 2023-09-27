package ddit.chapter03.sec01;
/*    입력          출력
 * A    B   AND   OR   EX-or /0=false,1=ture
 * 0	0	 0	  0      0
 * 0	1	 0	  1		 1
 * 1	0    0    1      1
 * 1	1    1    1      0
 */
public class ArithmeticOperatorExample02 {
	//논리연산자 : !(not), &&(and), ||(or)
	public static void main(String[] args) {
		logicaloperator();
		bitwise();
		

	}
	public static void logicaloperator() {
		char ch='0'; //숫자 0을 ASCii코드로 바꾼 것, 문자 0은 48
		int num = 100;
		System.out.println("1=>"+(int)'1');
		System.out.println("a=>"+(int)'a');
		boolean flag = ch>'a' && num!=50;
		System.out.println("and=>"+flag);
		
		System.out.println("or=>"+(ch>'a' || num!=50));
	}
	public static void bitwise() {
		// 비트별 (&,|,^ ) - 이진수:같은 위치의 비트별로 and, or, ex-or 연산
		// 						결과는 숫자자료로 반환
		
		int val1=27; //11011
		int val2=19; //10011
		
		System.out.println("비트별 and : "+(val1 & val2));
		System.out.println("비트별 or : "+(val1 | val2));
		System.out.println("비트별 ex-or : "+(val1 ^ val2));
	
	}
}
