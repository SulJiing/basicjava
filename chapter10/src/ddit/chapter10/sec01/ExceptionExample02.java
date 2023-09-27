package ddit.chapter10.sec01;
//09.07.03
public class ExceptionExample02 {
	static int sum = 0;
	static int avg = 0;
	public static void main(String[] args) {
		init();
	}

	public static void init() {
		try {
			exceptionMethod01();
		} catch (ArithmeticException e) {
			System.out.println("산술연산 오류");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 부존재 오류");
		} catch (Exception e) {
			System.out.println("그 밖의 예외");
		}
	}
	public static void exceptionMethod01() throws ArithmeticException, ClassNotFoundException, Exception{
//		int sum = 0;
//		int avg = 0;
//		try {
			int [] score = {10,20,30,40,50,60,70,80,90,100};
			sum = 0;
			int d =0;
			for (int i = 0; i < score.length; i++) {
				d=i+1;
				if(i==7) d=0;
				sum+=score[i]/d;
			}
			avg = sum/score.length;
//		} catch (NumberFormatException e) {
//			System.out.println("수치변환 예외발생");
//			System.out.println("합계 : "+sum);
//			System.out.println("평균 : "+avg);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열 첨자 예외발생");
//			System.out.println("합계 : "+sum);
//			System.out.println("평균 : "+avg);
//		} catch (Exception e) {
//			System.out.println("모든 예외발생");
//			System.out.println("합계 : "+sum);
//			System.out.println("평균 : "+avg);
//		}
		System.out.println("프로그램 수행 종료");
	}

}
