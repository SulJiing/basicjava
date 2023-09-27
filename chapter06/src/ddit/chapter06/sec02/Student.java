package ddit.chapter06.sec02;
//08.29
public class Student {
	final String MAJOR = "소프트웨어 학과";
	static long stdID=2023000L;
	
	public Student() {
		stdID++;
	}
	
	public long getStdID() {
		return stdID;
	}
}
