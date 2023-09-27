package ddit.chapter03.sec01;
// 삼항 연산자  08.17
import java.util.Scanner;

public class ArithmeticOperatorExample03 {

	public static void main(String[] args) {
		// 키보드로 점수하나를 입력받아 그 나이에 해당하는 연령대를 구하고 연령대가 
		// ~ 20대 : 청년세대 / 30~50대 : 장년세대 / 60대 이후 : 노년세대
		// ex) 17 => 10대, 81 => 80대, 11 => 10대 ...
		Scanner sc = new Scanner(System.in);
		System.out.print("나이입력 : ");
		int age = sc.nextInt();
		int ageGroup = age/10;
		
		String g = (ageGroup<3) ? "청년세대" : (ageGroup<6 && ageGroup>=3) ? "장년세대" : "노년세대";
			// 이미 3이상이기 때문에 넘어갔기 때문에 굳이 3보다 커야 한다는 조건은 없어도 됨
		System.out.println("나이 : " + age + " => " + g);
}

}
