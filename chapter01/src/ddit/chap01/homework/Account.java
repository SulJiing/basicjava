package ddit.chap01.homework;
//08.31
public class Account {
	private String owner; // �����
	private long balance; // �ܰ�

	public Account(String owner) {
		this.owner = owner;
		balance = 0;
	}
	Account() {
	} // �⺻ ������ - �Ű������� �����ʴ� ������

	public String getOwner() {
		return owner;
	}
	//�⺻�����ڿ� ���Ͽ� ������ ��ü�� ������ ����
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getBalance() { // �ܰ� Ȯ���� �� �ִ� �޼ҵ�
		return balance;
	}
//	public void setBalance(long balance) {
//		this.balance = balance;
//	}
	public void deposit(long money) { //�Աݸ޼ҵ�(�Ա��Ҿ׼�)
		balance = balance + money;
	}

	public long withdraw(long money) {//��ݸ޼ҵ�(����ұݾ�)
		if (balance < money) {
			System.out.println("�ܾ׺���");
			return 0;
		} else {
			balance = balance - money;
			return money;
		}
	}
}
