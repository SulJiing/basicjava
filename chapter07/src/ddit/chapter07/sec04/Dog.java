package ddit.chapter07.sec04;
//09.05
public class Dog extends Pet {
	String name;
	
	Dog(int age, String name){
		super(age);
		this.name=name;
	}
	
	@Override
	void walk() {
		System.out.println(name+"��(��) �׹߷� �ٴѴ�.");

	}

	@Override
	void eat() {
		System.out.println("��Ḧ �Դ´�");

	}

}
