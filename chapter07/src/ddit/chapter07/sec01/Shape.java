package ddit.chapter07.sec01;
//09.01
public class Shape {
	String kind;

	Shape(String kind) {// ������
		this.kind = kind;
	}

	Shape() {
	}

	public void getArea() {
		System.out.println("������ ������ ���մϴ�.");
	}

	@Override
	public String toString() {
		return kind;
	}
}