package ddit.chapter07.sec02;
//09.04
public class Computer extends Product {
	int price = 19000;//upcasting이라 부모클래스의 것만 호출됨
	public Computer() {
		super(15000);
	}
	
	@Override
	public String toString() {
		return "SAMSUNG NoteBook";
	}
}
