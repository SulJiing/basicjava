package ddit.chap02.sec04;

public class OneyearExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int day = (int) 365.2422;

		double hour = 0.2422 * 24; //5.8128�̶�� �����Ͱ� ���� int�� �� �Ҽ��� �ڸ��� �о���
		
		int h = (int) hour;
		
		double miu = (hour-5) * 60; //5.8128�̶�� �����Ϳ��� �ð��� 5�� ���ְ� 60�� ������ �� int�� �� �Ҽ��� �ڸ��� �о���
		int m = (int) miu;
		
		double sec = (miu-48) * 60; // 48.768...�̶�� �����Ϳ��� ���� 48�� ���ְ� 60�� �����־� int�� �� �Ҽ��� �ڸ��� �о���
		int s = (int) sec;
		
		System.out.print("\"1���� "+day+"�� "+h+"�ð� "+m+"�� "+s+"���Դϴ�\"");
	}

}