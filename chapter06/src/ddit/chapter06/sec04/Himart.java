package ddit.chapter06.sec04;

public class Himart {

	public static void main(String[] args) {
		Tv t1 = new Tv("LG caption Tv 60", 5000);
		Tv t2 = new Tv("Samsung Tv 80", 7500);
		
		Audio a1 = new Audio("Inkel", 2500);
		
		Computer c1 = new Computer("LG Gram 15", 12000);
		Computer c2 = new Computer("Samsung Note 15", 15000);
		Computer c3 = new Computer("Mac pro 13", 20000);
		
		Buyer b1 = new Buyer();
		
		b1.buy(c2);
		b1.buy(c3);
		b1.buy(t2);
		
		b1.summary();
	}

}
