package ddit.chap02.sec04;

public class CastExample02 {

	public static void main(String[] args) {
		double year=365.2422;
		int days=(int)year;//��
		
		double hour=(year-days)*24;//�ð�
		int hours=(int)hour;
		
		double minute=(hour-hours)*60;
		int minutes=(int)minute;
		
		double second=(minute-minutes)*60;
		int seconds=(int)second;
				
		
		System.out.println("1���� "+days+"�� "+hours+"�ð� "+minutes+"�� "+seconds+"���Դϴ�");
		
	}

}
