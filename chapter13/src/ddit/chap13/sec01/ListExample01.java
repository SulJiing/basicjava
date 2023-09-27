package ddit.chap13.sec01;

import java.util.ArrayList;
import java.util.Iterator;
//09.08.06
public class ListExample01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		list.add("ȫ�浿"); // ������ ����
		list.add(90);
		list.add(23.56);
		list.add(new Student(2302301L, "�̼���"));

		System.out.println(list);

		System.out.println(list.contains("ȫ�浿")); // ������ Ȯ�� => true
		System.out.println(list.contains("ȫ���")); // ������ Ȯ�� => false

		// ��ü��ȸ 1
		System.out.println("\n[[ for�� ��� ]]");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// ��ü��ȸ 2
		System.out.println("\n[[ ����� ��ȭ�� for�� ��� ]]");
		for (Object obj : list) { //Object : list�ȿ� �ִ� Ÿ�Ե��� ��� ������ �� ����
			System.out.println(obj);
		}
		// ��ü��ȸ 3
		System.out.println("\n[[ Iterator ��� ]]");
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
	}
}

class Student {
	String name;
	long stdId;

	Student(long stdId, String name) {
		this.stdId = stdId;
		this.name = name;
	}

	@Override
	public String toString() {
		return stdId + "=>" + name;
	}
}