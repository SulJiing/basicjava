package ddit.chapter10.sec01;
//09.07.03
public class AnimalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Dog();
		// downcast
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
			System.out.println(dog.name);
		}
		
		if (animal instanceof Cat) {
			Cat cat = (Cat) animal;
			System.out.println(cat.name);
		}else {
			System.out.println("downcast �� �� ����");
		}
	}
}

abstract class Animal {

}

class Dog extends Animal {
	String name = "�۸���";
}

class Cat extends Animal {
	String name = "�߿���";

}