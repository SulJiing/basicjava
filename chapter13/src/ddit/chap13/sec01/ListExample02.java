package ddit.chap13.sec01;

import java.util.ArrayList;
import java.util.List;

//09.08.07
public class ListExample02 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>(); //Student Ŭ���� Ÿ���� �����͸� ������ �� �ְԵ�
		
		list.add(new Student(23021l, "ȫ�浿")); //���� ��Ű���� Student Ŭ���� ���� �� �� ����
		list.add(new Student(20001l, "������"));
		list.add(new Student(22031l, "������"));
		list.add(new Student(23121l, "�۽ÿ�"));
		
		// �й��� ����
		for(Student s : list) {
			System.out.println("�й� : "+s.stdId);
		}
	}

}
