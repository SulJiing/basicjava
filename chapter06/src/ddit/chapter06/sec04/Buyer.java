package ddit.chapter06.sec04;
//08.30
// 구매목록, 총 구매금액, 총 보너스포인트가 멤버변수로 들어가야 함
public class Buyer {	
	String items;
	int sum;
	int bp;
	
	public void buy(Tv t) { //3개의 메소드는 오버로딩되어짐
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
		System.out.println("구매목록 : "+items);
		System.out.println("구매금액 합계 : "+sum);
		System.out.println("보너스포인트 : "+bp);
	}
}
