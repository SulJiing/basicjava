package ddit.chater05.sec05;
//08.28
public class ObjectArray02 {
	Book [] books;
	public static void main(String[] args) {
		new ObjectArray02().init();

	}

	public void init() {
		books = new Book[] {new Book("왕초보 영어", "EBS", 15000),
							new Book("경제인문학", "박정호", 30000),
							new Book("문과생의 과학 공부하기", "유시민", 17000)};
		infoBook();
	}
	
	public void infoBook() {
		for(Book b : books) { //(타입명 변수명 : 배열명)
			System.out.println("----------------------------");
			System.out.println(b);
		}
		System.out.println("----------------------------");
	}
}
