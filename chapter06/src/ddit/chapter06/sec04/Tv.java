package ddit.chapter06.sec04;
//08.30
public class Tv {
	String gName="";
	int price;
	int bonusPoint;
	
	Tv(String gName, int price){
		this.gName=gName;
		this.price=price;
		bonusPoint=(int)(price*0.01);
	}
	@Override
	public String toString() {
		return gName;
	}
}
