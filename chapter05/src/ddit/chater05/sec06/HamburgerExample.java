package ddit.chater05.sec06;
//09.01
enum Hamburger {
	CHICKIN_BURGER(5000), BIGMAC(4500), CHEESEBURGER(3500); //하나의 객체

	private final int price;

	private Hamburger(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}

public class HamburgerExample {

	public static void main(String[] args) {
//		Hamburger h;
		Hamburger[] hamburger = Hamburger.values();
		System.out.println("                   메         뉴");
		System.out.println("----------------------------------------------");
		for (Hamburger burger : hamburger) {
			System.out.printf("%15s : %6d원\n", burger, burger.getPrice());
		}
		System.out.println("----------------------------------------------");
	}
}
