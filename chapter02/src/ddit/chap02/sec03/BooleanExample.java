package ddit.chap02.sec03;

public class BooleanExample {

	public static void main(String[] args) {
		// boolean : true/false를 보관할 수 있는 변수
		// 조건문 구성에 사용되는 수식의 결과값
		// 다른 7가지의 기본형은 boolean타입으로 바뀔 수 없고 boolean형도 다른 타입으로 형변환 되지 않음
		int age = 105;
		boolean f = age >= 18;
		System.out.println("f="+f);
	}

}