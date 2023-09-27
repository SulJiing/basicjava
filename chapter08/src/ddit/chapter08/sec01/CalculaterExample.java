package ddit.chapter08.sec01;
//09.07.1
public class CalculaterExample {

	public static void main(String[] args) {
		CompleteCalc cc = new CompleteCalc(15);
		
		System.out.println("µ¡¼À : "+cc.add(1205, 4963));
		System.out.println("»¬¼À : "+cc.subtract(1205, 4963));
		System.out.println("¿øÀÇ ³ÐÀÌ : "+cc.getArea());

	}

}
