package ddit.chapter07.sec01;
//09.01
public class ShapeExample {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.getArea();
		
		Circle circle = new Circle();
		circle.kind = "Ÿ��";
		circle.radius = 12.5;
		circle.getArea();

		Circle circle2 = new Circle("Ÿ��2", 10);
		circle2.getArea();

		Trianglel trianglel = new Trianglel("�ﰢ��", 100, 250);
		trianglel.getArea();

		Rectangle rectangle = new Rectangle("�簢��", 52, 17);
		rectangle.getArea();

		Shape s1 = new Shape("������");
		System.out.println(s1);
	}

}
