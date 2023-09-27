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
// source에 Getters와Setters
	// Setters 메소드는 외부에서 데이터를 받아 멤버변수에 값을 저장함 - 매개변수 o , 반환타입 x
	// Getters 메소드는 내부에서 데이터를 받아 밖으로 빼내는 것 - 매개변수 x , 반환타입 o
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