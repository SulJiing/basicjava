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
		return "탱크";
	}
}

class Marine extends GroundUnit{
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "해병";
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
			System.out.println(u + "의 수리가 완료 되었습니다");
		}
	}

	@Override
	public String toString() {
		return "수리공장";
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
		return "수송선";
	}
}