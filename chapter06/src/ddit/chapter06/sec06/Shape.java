package ddit.chapter06.sec06;
//08.31
public final class Shape {
	String kind;
	
	Shape(String kind) {
		this.kind=kind;
	}
	
	 public final void getArea() {
		System.out.println("도형의 종류 : " + kind);
	}
}
