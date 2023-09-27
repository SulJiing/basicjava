package ddit.chap01.study.lotto;

import java.util.Scanner;

public class Person {

	String name = "";
	int money = 10000;
	int[][][] bundle;
	Lotto l = new Lotto();

	public static void main(String[] args) {
		Person person = new Person();
		person.name = "�鿵��";
		// Scanner sc = new Scanner(System.in);
		person.buyLotto(7000);
		person.lottoPrint();
	}

	public void buyLotto(int num) {
		if (money < num) {
			System.out.println("���� ���� ����" + money + "��" + num + "��ŭ�� �ζǸ� �� �� �����ϴ�.");
			return;
		}
		money = money - num;
		bundle = l.buyLottoBundle(num / 1000);
	}

	public void lottoPrint() {
		Lotto l = new Lotto();
		l.printLotto(bundle);
	}

	@Override
	public String toString() {
		if (bundle != null) {
			lottoPrint();
		}
		return "name " + name + ", " + " money" + money;
	}
}
