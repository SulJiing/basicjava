package ddit.chapter07.sec02;
//09.04
public class Computer extends Product {
	int price = 19000;//upcasting�̶� �θ�Ŭ������ �͸� ȣ���
	public Computer() {
		super(15000);
	}
	
	@Override
	public String toString() {
		return "SAMSUNG NoteBook";
	}
}
