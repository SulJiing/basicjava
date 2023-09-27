package ddit.chap11.sec01;
//09.08.03
public class ClassExample {

	public static void main(String[] args) throws Exception{
		 infoPersonClass();
	}
	
	public static void infoClass() throws Exception {
// 		클래스 정보를 취득하는 방법
//		1)Object class의 getClass()사용
		String s = new String();
		Class cinfo = s.getClass();
		
//		2)클래스 파일명을 Class변수에 직접 대입
		Class cinfo2 = String.class;
		
//		3)Class.forName()메서드 사용
		Class cinfo3 = Class.forName("java.lang.String");
	}
	public static void infoPersonClass() throws Exception {
		Person p1 = new Person();
		Class pcls = p1.getClass();
		System.out.println(pcls.getName());
		
		Class pcls1 = Person.class;
		System.out.println(pcls1.getName());
		
		Class pcls2 = Class.forName("ddit.chap11.sec01.Person");
		System.out.println(pcls2.getName());
	}
}
class Person{
	private String name;
	private int age;
	
	Person(){}
	
	Person (String name, int age){
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}