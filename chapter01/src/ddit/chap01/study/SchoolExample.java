package ddit.chap01.study;
//09.04
import java.util.Scanner;

public class SchoolExample {

public static void main(String[] args) {
//	Student [] stu = new Student[5];
	Student [] stu = { new Student ("대전초등학교", "1-가", "이순신", "홍길동"),
					   new Student ("대전초등학교", "1-가", "이순신", "정몽주"),
					   new Student ("대전초등학교", "1-다", "김영현", "강감찬"),
					   new Student ("대전초등학교", "1-나", "김헬렌", "이성현"),
					   new Student ("대전초등학교", "1-다", "김영현", "홍길순")};
	
	String grade = "";
	String tName = "";
	String schName = "";
	String [] stuName = new String[stu.length];
	int j =0;
	
	Scanner sc = new Scanner(System.in);
	System.out.print("조회학생 이름 : ");
	String sName=sc.next();
	
	for(int i=0; i<stu.length; i++) {
		if(sName.equals(stu[i].getStudName())) {
			schName=stu[i].getSchoolName();
			grade=stu[i].getGrade();
			tName=stu[i].getTeacherName();
			for (int k = 0; k < stu.length; k++) {
				if(stu[k].getTeacherName().equals(tName)) {
					stuName[j]=stu[k].getStudName();
					j++;
				}
			}
		}
	}
	System.out.println("조회결과");
	System.out.println("----------------------------");
	System.out.println("학교명 : "+schName);
	System.out.println("반 : "+grade);
	System.out.println("담임 : "+tName);
	System.out.print("반구성원 : ");
	for (int i = 0; i < stuName.length; i++) {
		if(stuName[i] !=null) {
			System.out.printf("%5s, ",stuName[i]);
		}
	}
	System.out.println("\n----------------------------");
}
}
