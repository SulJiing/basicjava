package ddit.chapter06.sec01;
//08.28
public class Employee {
	private long empId;
	private String empName;
	private String deptName;
	private int salary;
	
	Employee(long empId, String empName){
		this.empId=empId;
		this.empName=empName;
		
	}
// source�� Getters��Setters
	// Setters �޼ҵ�� �ܺο��� �����͸� �޾� ��������� ���� ������ - �Ű����� o , ��ȯŸ�� x
	// Getters �޼ҵ�� ���ο��� �����͸� �޾� ������ ������ �� - �Ű����� x , ��ȯŸ�� o
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return empId+"\t"+empName+"\t"+salary+"\t"+deptName;
	}
}