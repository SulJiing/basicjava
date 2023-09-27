package ddit.chapter07.sec04;

public class UnitTest {

	public static void main(String[] args) {
		unit u = new DropShip(); //다형성
		u.move(200, 350);
//		unit u1 = new unit(); //추상클래스가 존재하기 때문에 객체생성 하지 못함

		DropShip ds1 = null;
		if (u instanceof DropShip) {
			ds1 = (DropShip) u;
		}
		ds1.loadUnload();
	}
}
