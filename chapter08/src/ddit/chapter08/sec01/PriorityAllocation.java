package ddit.chapter08.sec01;
//09.04.2
public class PriorityAllocation implements Scheduler {
	// 3) �켱������ ���� ��� (PriorityAllocation): ���� ��޿� ���� ����� ���� �������� ó��
	@Override
	public void getNextCall() {
		System.out.println("���� ����� ���Ͽ� ���� ���� ����� ����ȭ�� �����´�.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("�������� �ɷ��� ����� ������� ��⿭ ���� �����ȭ�� �й��Ѵ�.");
	}
}
