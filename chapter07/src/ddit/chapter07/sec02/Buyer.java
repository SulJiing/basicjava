package ddit.chapter07.sec02;
//09.04
public class Buyer {
	int money; //������ �ִ� ���� �׼�
	int bonusPoint;
	String items=""; //���Ը��
	int sum; //���Աݾ�
	
	public Buyer(int money) {
		this.money=money;
	}
	
	void buy(Product p) {
		if(money>=p.price) {
			sum+=p.price;
			bonusPoint+=p.bonusPoint;
			items=items+p+", ";
			money-=p.price;
		}else {
			System.out.println("�ܾ��� �����մϴ�...");
		}
//		Computer c = (Computer)p; //downcasting
//		Tv t = (Tv)p;
//		instanceof ������ ���
//		��ü	instanceof Ŭ���� p instanceof Computer
		if(p instanceof Audio) {
			Audio a = (Audio)p;
			System.out.println(a+"�� ���� : "+a.price);
		} else if (p instanceof Tv){
			Tv t = (Tv)p;
			System.out.println(t+"�� ���� : "+t.price);
		} else if (p instanceof Computer) {
			Computer c = (Computer)p;
			System.out.println(c+"�� ���� : "+c.price);
		}
		System.out.println(p+"�� ���� : "+p.price);
//		System.out.println(t+"�� ���� : "+t.price);
//		Audio a = (Audio)p; //����:Ŭ����ĳ��Ʈ�ͼ���
		
	}
	void summary() {
		System.out.println("���Ÿ�� : "+items);
		System.out.println("���űݾ� : "+sum);
		System.out.println("���� �� �ܰ� : "+money);
	}
}
