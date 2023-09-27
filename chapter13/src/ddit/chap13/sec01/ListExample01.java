package ddit.chap13.sec01;

import java.util.ArrayList;
import java.util.Iterator;
//09.08.06
public class ListExample01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		list.add("홍길동"); // 데이터 저장
		list.add(90);
		list.add(23.56);
		list.add(new Student(2302301L, "이성계"));

		System.out.println(list);

		System.out.println(list.contains("홍길동")); // 데이터 확인 => true
		System.out.println(list.contains("홍길순")); // 데이터 확인 => false

		// 전체조회 1
		System.out.println("\n[[ for문 사용 ]]");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 전체조회 2
		System.out.println("\n[[ 기능이 강화된 for문 사용 ]]");
		for (Object obj : list) { //Object : list안에 있는 타입들을 모두 포괄할 수 있음
			System.out.println(obj);
		}
		// 전체조회 3
		System.out.println("\n[[ Iterator 사용 ]]");
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