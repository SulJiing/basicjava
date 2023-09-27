package ddit.chap01.study;

//09.04
public class School {
	public void moonje() {

		// �л��� �ڽ��� �̸��� �Է��ϸ� �ڽ��� �ݰ� ���Ӽ�����, �׸��� ���� ģ�����̸����� ��� Consoleâ�� ����� �ǰ��ϴ� ���α׷�
		//
		// ���Ǵ� Class�� �� �װ��� School, Teacher, Student, SchoolExample
		//
		// [School]
		// �б��� �ǹ��ϴ� Ŭ������, �б��̸��� �б��� ��� �׸��� �л����� �̸��� �����Ե��� �̸��� ����ʵ� �ڿ����� �������ִ�.
		// �л��� �̸����� �л��� ���� ���� return �ϴ� ����� ���� �޼��带 �������ִ�.
		// �л��� �̸����� �л��� ����ϴ� �������� �̸��� return �ϴ� ����� ���� �޼��带 �������ִ�.
		//
		// [Teacher]
		// �������� �ǹ��ϴ� Ŭ������, School Ŭ������ ��ӹ޴� �ڽ� Ŭ����
		// ���ÿ� Student Ŭ������ �ڽ� Ŭ������
		//
		// [Student]
		// �л��� �ǹ��ϴ� Ŭ������, TeacherŬ������ ��ӹ޴� �ڽ� Ŭ����
		//
		// [SchoolExample]
		// ���θ޼��尡 ���Ե� Ŭ������ ���α׷��� ���� Ŭ����
		// �л��� �̸��� �Է¹޾� Consoleȭ�鿡 ������� ����ϴ� �޼��� ����
	}

	String schoolName;
	String grade;

	School(String schoolName, String grade) {
		this.schoolName = schoolName;
		this.grade = grade;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getGrade() {
		return grade;
	}

}

class Teacher extends School {
	String teacherName;

	Teacher(String schoolName, String grade, String teacherName) {
		super(schoolName, grade);
		this.teacherName = teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}
}

class Student extends Teacher {
	String studName;

	Student(String schoolName, String grade, String teacherName, String studName) {
		super(schoolName, grade, teacherName);
		this.studName = studName;
	}

	public String getStudName() {
		return studName;
	}
}