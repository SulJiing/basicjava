package ddit.chapter07.sec04;

public class Marine extends unit {

	Marine(int x, int y) {
		super(x, y);
	}

	@Override
	void move(int x1, int y1) {
		System.out.println("(" + x + "," + y + ")���� (" + (x + x1) + "," + (y + y1) + ")���� �ɾ �̵�");
	}

	void steamPack() {
		System.out.println("�������� ����ϴ�");
	}
}
