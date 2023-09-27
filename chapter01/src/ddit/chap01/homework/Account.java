package ddit.chap01.homework;
//08.31
public class Account {
	private String owner; // 사용자
	private long balance; // 잔고

	public Account(String owner) {
		this.owner = owner;
		balance = 0;
	}
	Account() {
	} // 기본 생성자 - 매개변수를 갖지않는 생성자

	public String getOwner() {
		return owner;
	}
	//기본생성자에 의하여 생성된 객체에 예금주 설정
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getBalance() { // 잔고를 확인할 수 있는 메소드
		return balance;
	}
//	public void setBalance(long balance) {
//		this.balance = balance;
//	}
	public void deposit(long money) { //입금메소드(입금할액수)
		balance = balance + money;
	}

	public long withdraw(long money) {//출금메소드(출금할금액)
		if (balance < money) {
			System.out.println("잔액부족");
			return 0;
		} else {
			balance = balance - money;
			return money;
		}
	}
}
