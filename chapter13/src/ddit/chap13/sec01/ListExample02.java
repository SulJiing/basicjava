package ddit.chap13.sec01;

import java.util.ArrayList;
import java.util.List;

//09.08.07
public class ListExample02 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>(); //Student 클래스 타입의 데이터만 저장할 수 있게됨
		
		list.add(new Student(23021l, "홍길동")); //같은 패키지라 Student 클래스 가젿 쓸 수 있음
		list.add(new Student(20001l, "강감찬"));
		list.add(new Student(22031l, "정몽주"));
		list.add(new Student(23121l, "송시열"));
		
		// 학번만 추출
		for(Student s : list) {
			System.out.println("학번 : "+s.stdId);
		}
	}

}
