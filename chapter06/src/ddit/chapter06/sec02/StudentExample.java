package ddit.chapter06.sec02;
//08.29
public class StudentExample {

	public static void main(String[] args) {
		System.out.println("�й� : "+Student.stdID);
		Student s1 = new Student();
//		s1.major="����Ʈ���� �а�";
		
		System.out.println("�а� : "+s1.MAJOR);
		System.out.println("�й� : "+Student.stdID);
		
		Student s2 = new Student();
//		s2.major="����Ʈ���� �а�";
		
		System.out.println("�а� : "+s2.MAJOR);
		System.out.println("�й� : "+Student.stdID);
	}

}
