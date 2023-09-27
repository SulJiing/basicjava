package ddit.chapter07.sec03;
//09.04
interface Repairable {}

class Unit {
	int hitPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit {
	public GroundUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	public Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "��ũ";
	}
}

class Marine extends GroundUnit{
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "�غ�";
	}
}

class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super(100);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			while (u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u + "�� ������ �Ϸ� �Ǿ����ϴ�");
		}
	}

	@Override
	public String toString() {
		return "��������";
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

class DropShip extends AirUnit  implements Repairable {
	DropShip() {
		super(125);
	}

	@Override
	public String toString() {
		return "���ۼ�";
	}
}