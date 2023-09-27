package ddit.chapter06.sec05;
//08.31 싱글톤 (일단 그냥 외우기)
public class Account {
	private String ower;
	private long balance;
	// Singleton 작성방법
	
	// 1. private 객체변수 선언(private, static, 타입은 자기 클래스 타입, 변수명 보통 instance)
	private static Account instance = null;

	// 2. 생성자 메서드 선언(private 접근지정자)
	private Account() {
		ower = "백영웅";
	}

	// 3. getInstance메서드(public 접근지정자, static, 반환타입은 자기 클래스)
	public static Account getInstance() {
		if (instance == null) {
			instance = new Account();
		}
		return instance;
	}
}
