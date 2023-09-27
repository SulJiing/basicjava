package ddit.chapter07.sec04;

public class DropShip extends unit {

	DropShip() {
		super(0, 0);
	}

	@Override
	void move(int x1, int y1) {
		System.out.println("(" + x + "," + y + ")에서 (" + (x + x1) + "," + (y + y1) + ")으로 비행하여 이동");
	}

	void loadUnload() {
		System.out.println("탑승하다");
	}

}
