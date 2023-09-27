package ddit.chap02.sec03;

//실수형(소수점이 있는 수) : float(4byte), double(8byte:기본형)
public class FloatExample {

	public static void main(String[] args) {
		floatMethod();
		doubleMethod();
	}

	public static void floatMethod() {
		// float: 4byte(1 bit : 부호, 8bit(까지) : 지수, 23bit : 가수(소수점 이하의 수)
		// 1.4e(x10)-45(승=지수) ~ 3.4e(x10)+38(승=지수) : long타입보다 큰 크기의 데이터 저장
		// 데이터 끝에 반드시 'f'('F')를 기술하여 float type임을 컴파일러에게 알려야 함.
		float pi = 3.1415926f;
		int radius = 15;// 반지름 = 15

		System.out.println("원의 넓이 =" + (radius * radius * pi));
		System.out.println("원둘레 =" + (2 * radius * pi)); // 2가 int 값이더라도 float가 큰값이기때문에 따라감
		// 소수점 둘째자리에서 반올림하는 방법=x10
	}

	public static void doubleMethod() {
		// double: 8byte(1 bit : 부호, 11bit(까지) : 지수, 52bit : 가수(소수점 이하의 수)
		// 4.9e(x10)-324(승=지수) ~ 1.8e(x10)+308(승=지수) :가장 큰 크기의 데이터 저장
		// 데이터 끝에 'd'('D')를 기술하거나 생략할 수 있음

		double d1 = 0.1D;
		double d2 = 0.1F; // float타입을 double로 변환해서 double에 저장한 것 / 위와 값은 다름 - 변환오차가 생김

		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);
	}

}
