package ddit.chapter07.sec04;

public class Marine extends unit {

	Marine(int x, int y) {
		super(x, y);
	}

	@Override
	void move(int x1, int y1) {
		System.out.println("(" + x + "," + y + ")에서 (" + (x + x1) + "," + (y + y1) + ")으로 걸어서 이동");
	}

	void steamPack() {
		System.out.println("스팀팩을 사용하다");
	}
}
