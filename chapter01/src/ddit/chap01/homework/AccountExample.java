package ddit.chap01.homework;
//08.31
public class AccountExample {

public static void main(String[] args) {
	Account ac = new Account();
//	System.out.println(ac.getOwner()); - null
	ac.setOwner("백영웅");
	printAccountInfo(ac);
	
	ac.deposit(100000);
	printAccountInfo(ac);
	ac.withdraw(50000);
	printAccountInfo(ac);
}
	public static void printAccountInfo(Account ac) {
		System.out.println("예금주 : "+ac.getOwner()); //- 백영웅
		System.out.println("잔고 : "+ac.getBalance()+"원 입니다.");
		System.out.println("-----------------------------");
	}
}

