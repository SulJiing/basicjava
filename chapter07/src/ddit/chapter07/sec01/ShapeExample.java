package ddit.chapter07.sec01;
//09.01
public class ShapeExample {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.getArea();
		
		Circle circle = new Circle();
		circle.kind = "타원";
		circle.radius = 12.5;
		circle.getArea();

		Circle circle2 = new Circle("타원2", 10);
		circle2.getArea();

		Trianglel trianglel = new Trianglel("삼각형", 100, 250);
		trianglel.getArea();

		Rectangle rectangle = new Rectangle("사각형", 52, 17);
		rectangle.getArea();

		Shape s1 = new Shape("오각형");
		System.out.println(s1);
	}

}
