package ddit.chapter07.sec02;
//09.04
public class HiMart {

	public static void main(String[] args) {
		Computer c1=new Computer();
		Audio a1=new Audio();
		Tv t1 = new Tv();
		
		Buyer buyer = new Buyer(100000);
		buyer.buy(c1);
//		buyer.buy(t1);
//		buyer.buy(a1);
//		buyer.buy(new Computer());
		
		buyer.summary();

	}

}
