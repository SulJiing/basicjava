package ddit.chapter08.sec01;

import java.io.IOException;
//09.04.2
public class SchedulerExample {

	public static void main(String[] args) throws IOException {
		System.out.println("�����ȭ �й��� ����");
		System.out.println("R : ������� �й�");
		System.out.println("L : ª�� ��⿭�� �������� �й�");
		System.out.println("P : �켱������ ���� ������ �Ҵ�");

		int c = System.in.read(); //�ѱ��� �о���̴� �޼���, try�� �ȿ����� ����ؾ� ��
//		try {
//			int c = System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Scheduler scheduler = null;

		if (c == 'R' || c == 'r') {
			scheduler = new RoundRoin();
		} else if (c == 'L' || c == 'l') {
			scheduler = new LeastJob();
		} else if (c == 'p' || c == 'p') {
			scheduler = new PriorityAllocation();
		} else {
			System.out.println("�й��� ������ �߸��Ǿ����ϴ�.");
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}

}
