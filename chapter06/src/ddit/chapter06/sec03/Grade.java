package ddit.chapter06.sec03;
//08.29
public class Grade {
	int sub1;
	int sub2;
	int sub3;
	int sum;
	
	Grade() { // 기본생성자(default Constructor) - 매개변수가 한개도 없음
		this(90, 80, 70); // 세번째 생성자를 호출
		sub1 = 90;
		sub2 = 80;
		sub3 = 70;
	}

	Grade(int sub1) {
		this(sub1,80,70);
//		this.sub1 = sub2;
//		sub2 = 80; // 위와 중복됨
//		sub3 = 70; // 위와 중복됨
	}

	Grade(int sub1, int sub2) {
		this(sub1, sub2, 70);
//		this.sub1 = sub1;	// 위와 중복됨
//		this.sub2 = sub2;	// 위와 중복됨
//		sub3 = 70;			// 위와 중복됨
	}

	Grade(int sub1, int sub2, int sub3) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	
	public int sum () { // (int sub1, int sub2, int sub3) 대신 sum변수를 만듦
		sum=sub1+sub2+sub3;
		return(sum);
	}
	
	public double avg() {
		return(double)sum/3;
	}
}
