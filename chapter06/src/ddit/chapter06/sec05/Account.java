package ddit.chapter06.sec05;
//08.31 �̱��� (�ϴ� �׳� �ܿ��)
public class Account {
	private String ower;
	private long balance;
	// Singleton �ۼ����
	
	// 1. private ��ü���� ����(private, static, Ÿ���� �ڱ� Ŭ���� Ÿ��, ������ ���� instance)
	private static Account instance = null;

	// 2. ������ �޼��� ����(private ����������)
	private Account() {
		ower = "�鿵��";
	}

	// 3. getInstance�޼���(public ����������, static, ��ȯŸ���� �ڱ� Ŭ����)
	public static Account getInstance() {
		if (instance == null) {
			instance = new Account();
		}
		return instance;
	}
}
