package ddit.chap01.homework;
//08.30
public class Circle {
	public double radius;
	final double PI = 3.141592;

// ������
	public Circle(double radius) {
		this.radius = radius;
	}

// ���� �������� ����Ͽ� ���� ������ ���ϴ� �޼ҵ�
	public double getArea() {
		return radius * radius * PI;
	}
}