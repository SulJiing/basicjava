package ddit.chap02.sec04;

public class OneyearExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int day = (int) 365.2422;

		double hour = 0.2422 * 24; //5.8128이라는 데이터가 나와 int로 뒤 소수점 자리를 털어줌
		
		int h = (int) hour;
		
		double miu = (hour-5) * 60; //5.8128이라는 데이터에서 시간인 5를 빼주고 60을 곱해준 후 int로 뒤 소수점 자리를 털어줌
		int m = (int) miu;
		
		double sec = (miu-48) * 60; // 48.768...이라는 데이터에서 분인 48을 빼주고 60을 곱해주어 int로 뒤 소수점 자리를 털어줌
		int s = (int) sec;
		
		System.out.print("\"1년은 "+day+"일 "+h+"시간 "+m+"분 "+s+"초입니다\"");
	}

}