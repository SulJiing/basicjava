package ddit.chap01.study;

//09.04
public class School {
	public void moonje() {

		// 학생이 자신의 이름을 입력하면 자신의 반과 담임선생님, 그리고 반의 친구들이름까지 모두 Console창에 출력이 되게하는 프로그램
		//
		// 사용되는 Class는 총 네개로 School, Teacher, Student, SchoolExample
		//
		// [School]
		// 학교를 의미하는 클래스로, 학교이름과 학교의 등급 그리고 학생들의 이름과 선생님들의 이름을 멤버필드 자원으로 가지고있다.
		// 학생의 이름으로 학생이 속한 반을 return 하는 기능을 가진 메서드를 가지고있다.
		// 학생의 이름으로 학생을 담당하는 선생님의 이름을 return 하는 기능을 가진 메서드를 가지고있다.
		//
		// [Teacher]
		// 선생님을 의미하는 클래스로, School 클래스를 상속받는 자식 클래스
		// 동시에 Student 클래스가 자식 클래스임
		//
		// [Student]
		// 학생을 의미하는 클래스로, Teacher클래스를 상속받는 자식 클래스
		//
		// [SchoolExample]
		// 메인메서드가 포함된 클래스로 프로그램의 시작 클래스
		// 학생의 이름을 입력받아 Console화면에 결과물을 출력하는 메서드 존재
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