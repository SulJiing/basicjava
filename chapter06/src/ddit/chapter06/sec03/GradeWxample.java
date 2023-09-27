package ddit.chapter06.sec03;

public class GradeWxample {

	public static void main(String[] args) {
		Grade g1 = new Grade();
		System.out.println("ÃÑÁ¡ : "+g1.sum());
		System.out.println("Æò±Õ : "+g1.avg());
		
		Grade g2 = new Grade(100);
		System.out.println("ÃÑÁ¡ : "+g2.sum());
		System.out.println("Æò±Õ : "+g2.avg());
		
		Grade g3 = new Grade(100,100);
		System.out.println("ÃÑÁ¡ : "+g3.sum());
		System.out.println("Æò±Õ : "+g3.avg());
		
		Grade g4 = new Grade(100,100,95);
		System.out.println("ÃÑÁ¡ : "+g4.sum());
		System.out.println("Æò±Õ : "+g4.avg());
		
	}

}
