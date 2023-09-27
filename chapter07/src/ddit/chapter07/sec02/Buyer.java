package ddit.chapter07.sec02;
//09.04
public class Buyer {
	int money; //가지고 있는 돈의 액수
	int bonusPoint;
	String items=""; //구입목록
	int sum; //구입금액
	
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
			System.out.println("잔액이 부족합니다...");
		}
//		Computer c = (Computer)p; //downcasting
//		Tv t = (Tv)p;
//		instanceof 연산자 사용
//		객체	instanceof 클래스 p instanceof Computer
		if(p instanceof Audio) {
			Audio a = (Audio)p;
			System.out.println(a+"의 가격 : "+a.price);
		} else if (p instanceof Tv){
			Tv t = (Tv)p;
			System.out.println(t+"의 가격 : "+t.price);
		} else if (p instanceof Computer) {
			Computer c = (Computer)p;
			System.out.println(c+"의 가격 : "+c.price);
		}
		System.out.println(p+"의 가격 : "+p.price);
//		System.out.println(t+"의 가격 : "+t.price);
//		Audio a = (Audio)p; //오류:클래스캐스트익셉션
		
	}
	void summary() {
		System.out.println("구매목록 : "+items);
		System.out.println("구매금액 : "+sum);
		System.out.println("구매 후 잔고 : "+money);
	}
}
