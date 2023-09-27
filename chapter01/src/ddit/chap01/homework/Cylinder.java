package ddit.chap01.homework;
//08.30
public class Cylinder {
//	 static double radius; //기본조건
//	 static double height; //기본조건
	double height;
	Circle ci = new Circle(2.8);

	public static void main(String[] args) {
//		radius = 2.8; //기본조건
		Cylinder cy = new Cylinder();
		cy.height = 5.6; // 기본조건
		System.out.println("원통의 부피 : " + cy.getVolume());
	}

	public double getVolume() {
		System.out.println("원의 넓이 : " + ci.getArea());
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
// 이렇게 하고 새 메인 포함 클래스 생성해서
// Cylinder c = new Cylinder(5.6,new Circle(2.8));
// System.out.println("원통의 부피 : "+c.getVolume());