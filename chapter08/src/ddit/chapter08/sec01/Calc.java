package ddit.chapter08.sec01;
//09.07.1
public abstract class Calc implements Calculater { 
	//추상클래스가 되어야 하는 이유는 나머지 타임즈와 디바이드 메서드를 재정의하지 않고 그대로 상속받았기 때문
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public int subtract(int num1, int num2) {
		return num1-num2;
	}
}
