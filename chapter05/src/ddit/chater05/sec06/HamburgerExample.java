package ddit.chater05.sec06;
//09.01
enum Hamburger {
	CHICKIN_BURGER(5000), BIGMAC(4500), CHEESEBURGER(3500); //�ϳ��� ��ü

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
		System.out.println("                   ��         ��");
		System.out.println("----------------------------------------------");
		for (Hamburger burger : hamburger) {
			System.out.printf("%15s : %6d��\n", burger, burger.getPrice());
		}
		System.out.println("----------------------------------------------");
	}
}
