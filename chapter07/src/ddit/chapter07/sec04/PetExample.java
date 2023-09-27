package ddit.chapter07.sec04;
//09.05
public class PetExample {

	public static void main(String[] args) {
		Dog d1 = new Dog(7, "향단이");
		d1.eat();
		d1.walk();
		System.out.println("나이 : "+d1.age);
		
		Pet p = new Dog(5, "멍멍이"); //다형성을 적용함
		p.eat();
		p.walk();
		System.out.println("나이 : "+p.age);
		
		Pet p1 = new Rabbit();
		System.out.println("나이 : "+p1.age);
		
	}

}
