package ddit.chapter06.sec01;
//08.28
public class EmployeeExample {
	public static void main(String[] args) {
		System.out.println("�����ȣ\t\t�����\t�޿�\t�μ���");
		System.out.println("------------------------------------------------------");
		Employee e1 = new Employee(202305001l, "ȫ�浿");
		// e1.deptName="IT���ߺ�"; - ����
		e1.setDeptName("IT���ߺ�");
		//e1.salary=2000000; - ����
		e1.setSalary(2000000);
		System.out.println(e1.toString());
	}
}
