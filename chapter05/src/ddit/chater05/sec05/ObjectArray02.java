package ddit.chater05.sec05;
//08.28
public class ObjectArray02 {
	Book [] books;
	public static void main(String[] args) {
		new ObjectArray02().init();

	}

	public void init() {
		books = new Book[] {new Book("���ʺ� ����", "EBS", 15000),
							new Book("�����ι���", "����ȣ", 30000),
							new Book("�������� ���� �����ϱ�", "���ù�", 17000)};
		infoBook();
	}
	
	public void infoBook() {
		for(Book b : books) { //(Ÿ�Ը� ������ : �迭��)
			System.out.println("----------------------------");
			System.out.println(b);
		}
		System.out.println("----------------------------");
	}
}
