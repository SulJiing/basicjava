package ddit.chapter06.sec02;
//08.29
public class Student {
	final String MAJOR = "����Ʈ���� �а�";
	static long stdID=2023000L;
	
	public Student() {
		stdID++;
	}
	
	public long getStdID() {
		return stdID;
	}
}
