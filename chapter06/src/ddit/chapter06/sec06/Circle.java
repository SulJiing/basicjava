package ddit.chapter06.sec06;
//08.31
public class Circle extends shape{
	final double PI;
//	final double PI=3.1415926;
	int radius;
	
	Circle(String kind, int radius) {
		super(kind);
		this.radius=radius;
		PI=3.1415926;
}
//	@Override
//	public void getArea() {
////		PI = PI*0.2; PI�� final�� ���� ����� �Ǿ��� ����
//		double area = PI*radius*radius;
//		System.out.println(kind+"���� ���� : "+area);
//	}
}