package ddit.chapter07.sec04;
//09.05
public abstract class Pet {
	int age;

	public Pet(int age) {
		this.age = age;
	}

	abstract void walk();

	abstract void eat();

	void run() {
		System.out.println("´Þ¸®´Ù");
	}

}
