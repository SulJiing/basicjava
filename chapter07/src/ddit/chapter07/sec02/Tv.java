package ddit.chapter07.sec02;
//09.04
public class Tv extends Product {
	int price = 20000;
	public Tv() {
		super(10000);
	}
	
	@Override
	public String toString() {
		return "LG ThinQ 80";
	}
}
