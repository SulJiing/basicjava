package ddit.chap01.homework;
//08.31
public class AccountExample {

public static void main(String[] args) {
	Account ac = new Account();
//	System.out.println(ac.getOwner()); - null
	ac.setOwner("�鿵��");
	printAccountInfo(ac);
	
	ac.deposit(100000);
	printAccountInfo(ac);
	ac.withdraw(50000);
	printAccountInfo(ac);
}
	public static void printAccountInfo(Account ac) {
		System.out.println("������ : "+ac.getOwner()); //- �鿵��
		System.out.println("�ܰ� : "+ac.getBalance()+"�� �Դϴ�.");
		System.out.println("-----------------------------");
	}
}

