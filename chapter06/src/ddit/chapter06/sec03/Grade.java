package ddit.chapter06.sec03;
//08.29
public class Grade {
	int sub1;
	int sub2;
	int sub3;
	int sum;
	
	Grade() { // �⺻������(default Constructor) - �Ű������� �Ѱ��� ����
		this(90, 80, 70); // ����° �����ڸ� ȣ��
		sub1 = 90;
		sub2 = 80;
		sub3 = 70;
	}

	Grade(int sub1) {
		this(sub1,80,70);
//		this.sub1 = sub2;
//		sub2 = 80; // ���� �ߺ���
//		sub3 = 70; // ���� �ߺ���
	}

	Grade(int sub1, int sub2) {
		this(sub1, sub2, 70);
//		this.sub1 = sub1;	// ���� �ߺ���
//		this.sub2 = sub2;	// ���� �ߺ���
//		sub3 = 70;			// ���� �ߺ���
	}

	Grade(int sub1, int sub2, int sub3) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	
	public int sum () { // (int sub1, int sub2, int sub3) ��� sum������ ����
		sum=sub1+sub2+sub3;
		return(sum);
	}
	
	public double avg() {
		return(double)sum/3;
	}
}
