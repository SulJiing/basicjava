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
		System.out.println(name+"은(는) 네발로 다닌다.");

	}

	@Override
	void eat() {
		System.out.println("사료를 먹는다");

	}

}
