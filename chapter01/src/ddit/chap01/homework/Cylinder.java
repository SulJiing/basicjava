package ddit.chap01.homework;
//08.30
public class Cylinder {
//	 static double radius; //�⺻����
//	 static double height; //�⺻����
	double height;
	Circle ci = new Circle(2.8);

	public static void main(String[] args) {
//		radius = 2.8; //�⺻����
		Cylinder cy = new Cylinder();
		cy.height = 5.6; // �⺻����
		System.out.println("������ ���� : " + cy.getVolume());
	}

	public double getVolume() {
		System.out.println("���� ���� : " + ci.getArea());
		return ci.getArea() * height;
	}
}
//double height;
//Circle c;
// Cylinder(double height, Circle c){
//	 this.height=height;
//	 this.c=c;
// }
// double getVolume() {
//	 return c.getArea()*height;
// }}
// �̷��� �ϰ� �� ���� ���� Ŭ���� �����ؼ�
// Cylinder c = new Cylinder(5.6,new Circle(2.8));
// System.out.println("������ ���� : "+c.getVolume());