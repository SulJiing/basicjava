package ddit.chapter07.sec01;
//09.01
public class Circle extends Shape{
	double radius;
	final double PI=3.1415926;
	
	Circle(String kind, double radius){
		super(kind);
		this.radius=radius;
	}
	
	Circle(){}

	@Override
	public void getArea() {
		System.out.println(kind+"≥–¿Ã : "+radius*radius*PI);
	}
}