package ddit.chater05.sec01;

//08.22
public class ReferenceExample01 {

	public static void main(String[] args) {
		//
		Person p1 = new Person();
		System.out.println("홍길동");
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = new String("홍길동");
		String str4 = new String("홍길동");

		if (str1 == str2) {
			System.out.println("같은주소");
		} else {
			System.out.println("다른주소");
		}

		if (str3 == str4) {
			System.out.println("같은주소");
		} else {
			System.out.println("다른주소");
		}
		System.out.println(str3);
	}

}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Override // 재정의 - 부모 클래스와 다르게 다시 정의한 조건으로 출력
	public String toString() {
		return name;
	}
}