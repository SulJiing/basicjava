package ddit.chapter07.sec01;
//09.01
public class Shape {
	String kind;

	Shape(String kind) {// 생성자
		this.kind = kind;
	}

	Shape() {
	}

	public void getArea() {
		System.out.println("도형의 면적을 구합니다.");
	}

	@Override
	public String toString() {
		return kind;
	}
}