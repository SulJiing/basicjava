package ddit.chapter08.sec01;
//09.07.1
public class CalculaterExample {

	public static void main(String[] args) {
		CompleteCalc cc = new CompleteCalc(15);
		
		System.out.println("���� : "+cc.add(1205, 4963));
		System.out.println("���� : "+cc.subtract(1205, 4963));
		System.out.println("���� ���� : "+cc.getArea());

	}

}
