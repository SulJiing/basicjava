package ddit.chapter07.sec01;
//09.01
public class Rectangle extends Shape {
	int width;
	int height;
	
	public Rectangle() {}//�⺻ ������

	Rectangle(String kind, int width, int height) {
		super(kind);
		this.height = height;
		this.width = width;
	}

	@Override
	public void getArea() {
		System.out.println(kind + "���� : " + width * height);
	}
}
