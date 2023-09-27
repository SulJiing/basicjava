package ddit.chater05.sec05;
//08.28
public class Book {
	private String title;
	private String writer;
	private int price;
	
	//생성자메소드
	public Book(String title, String writer, int price) {
		this.title=title;
		this.writer=writer;
		this.price=price;
	}
	
	@Override //투스트링 메소드
	public String toString() {
		String str = "제목 : "+title+"\n";
		str = str+"저자 : "+writer+"\n";
		str = str+"가격 : "+price;
		
		return str;
	}
	
}
