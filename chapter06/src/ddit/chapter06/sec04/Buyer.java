package ddit.chapter06.sec04;
//08.30
// ���Ÿ��, �� ���űݾ�, �� ���ʽ�����Ʈ�� ��������� ���� ��
public class Buyer {	
	String items;
	int sum;
	int bp;
	
	public void buy(Tv t) { //3���� �޼ҵ�� �����ε��Ǿ���
		items = items+t+", ";
		sum = sum+t.price;
		bp=bp+t.bonusPoint;
	}
	
	public void buy(Audio a) {
		items = items+a+", ";
		sum = sum+a.price;
		bp=bp+a.bonusPoint;
	}
	
	public void buy(Computer c) {
		items = items+c+", ";
		sum = sum+c.price;
		bp=bp+c.bonusPoint;
	}
	
	public void summary() {
		System.out.println("���Ÿ�� : "+items);
		System.out.println("���űݾ� �հ� : "+sum);
		System.out.println("���ʽ�����Ʈ : "+bp);
	}
}
