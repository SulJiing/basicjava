package ddit.chapter07.sec04;

public class UnitTest {

	public static void main(String[] args) {
		unit u = new DropShip(); //������
		u.move(200, 350);
//		unit u1 = new unit(); //�߻�Ŭ������ �����ϱ� ������ ��ü���� ���� ����

		DropShip ds1 = null;
		if (u instanceof DropShip) {
			ds1 = (DropShip) u;
		}
		ds1.loadUnload();
	}
}
