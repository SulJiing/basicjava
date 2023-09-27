package ddit.chap02.sec04;

public class CastExample02 {

	public static void main(String[] args) {
		double year=365.2422;
		int days=(int)year;//일
		
		double hour=(year-days)*24;//시간
		int hours=(int)hour;
		
		double minute=(hour-hours)*60;
		int minutes=(int)minute;
		
		double second=(minute-minutes)*60;
		int seconds=(int)second;
				
		
		System.out.println("1년은 "+days+"일 "+hours+"시간 "+minutes+"분 "+seconds+"초입니다");
		
	}

}
