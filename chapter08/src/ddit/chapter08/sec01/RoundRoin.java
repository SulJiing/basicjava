package ddit.chapter08.sec01;
//09.04.2
public class RoundRoin implements Scheduler {
	// 1) ������� ��� (RoundRoin)
	@Override
	public void getNextCall() {
		System.out.println("���� ��� ��ȭ�� ��⿭���� ���ʴ�� �����´�.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("��⿭���� ������ ��ȭ�� ���� �������� ���ʴ�� �й��Ѵ�.");
	}
}
