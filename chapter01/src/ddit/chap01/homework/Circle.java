package ddit.chap01.homework;
//08.30
public class Circle {
	public double radius;
	final double PI = 3.141592;

// 생성자
	public Circle(double radius) {
		this.radius = radius;
	}

// 현재 반지름을 사용하여 원의 면적을 구하는 메소드
	public double getArea() {
		return radius * radius * PI;
	}
}