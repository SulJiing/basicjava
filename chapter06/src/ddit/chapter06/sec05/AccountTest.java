package ddit.chapter06.sec05;
//08.31 �̱���
public class AccountTest {

	public static void main(String[] args) {
		Account at1 = Account.getInstance();
		Account at2 = Account.getInstance();
		System.out.println("ù ��° ������ �ּ� : "+at1);
		System.out.println("�� ��° ������ �ּ� : "+at2);
	}
}