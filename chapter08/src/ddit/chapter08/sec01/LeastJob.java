package ddit.chapter08.sec01;
//09.04.2
public class LeastJob implements Scheduler {
	// 2) ª�� ��⿭�� ��� (LeastJob) : ������� �ʰ� �ִ� �����̳� ��� ��ȭ�� ���� ���� ª�� �������� ���
	@Override
	public void getNextCall() {
		System.out.println("���� ��� ��ȭ�� ��⿭���� ���ʴ�� �����´�.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("���� ������� �ʴ� �������� ����ϰų� ��� ������ ��� ���̶�� ��⿭�� ���� ª�� �������� �й��Ѵ�.");
	}
}
