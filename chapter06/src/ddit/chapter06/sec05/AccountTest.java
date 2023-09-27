package ddit.chapter06.sec05;
//08.31 싱글톤
public class AccountTest {

	public static void main(String[] args) {
		Account at1 = Account.getInstance();
		Account at2 = Account.getInstance();
		System.out.println("첫 번째 계좌의 주소 : "+at1);
		System.out.println("두 번째 계좌의 주소 : "+at2);
	}
}