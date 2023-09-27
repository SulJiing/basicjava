package ddit.chapter06.sec01;
//08.28
public class EmployeeExample {
	public static void main(String[] args) {
		System.out.println("사원번호\t\t사원명\t급여\t부서명");
		System.out.println("------------------------------------------------------");
		Employee e1 = new Employee(202305001l, "홍길동");
		// e1.deptName="IT개발부"; - 오류
		e1.setDeptName("IT개발부");
		//e1.salary=2000000; - 오류
		e1.setSalary(2000000);
		System.out.println(e1.toString());
	}
}
