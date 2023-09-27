package ddit.chapter10.sec02;
//09.08.01
// 사용자 생성 예외 클래스
// - Exception class를 상속
// - throw 명령으로 예외를 강제발생
public class UserExceptionExample {

	public static void main(String[] args) {
		try {
			System.out.println("예외 발생");
			throw new MyException("사용자 생성 예외");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class MyException extends Exception{
	
	public MyException(String errMsg) {
		super(errMsg);
	}	
}