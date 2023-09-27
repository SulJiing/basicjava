package ddit.chapter07.sec03;
//09.04
public class PolyTest {

	public static void main(String[] args) {
		Tank tank = new Tank();
		DropShip dShip = new DropShip();
		Marine m = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dShip);
//		scv.repair(m);

	}

}
