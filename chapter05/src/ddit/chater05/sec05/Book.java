package ddit.chater05.sec05;
//08.28
public class Book {
	private String title;
	private String writer;
	private int price;
	
	//�����ڸ޼ҵ�
	public Book(String title, String writer, int price) {
		this.title=title;
		this.writer=writer;
		this.price=price;
	}
	
	@Override //����Ʈ�� �޼ҵ�
	public String toString() {
		String str = "���� : "+title+"\n";
		str = str+"���� : "+writer+"\n";
		str = str+"���� : "+price;
		
		return str;
	}
	
}
