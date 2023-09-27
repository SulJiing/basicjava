package ddit.chap04.sec01;

//08.18
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {

	public static void main(String[] args) {
// 컴퓨터와 사용자가 가위 바위 보 게임을 한다  이를 프로그램하시오  (가위 =>1, 바위 =>2, 보=> 3)
		Scanner sc = new Scanner(System.in);
		System.out.print("가위 =>1, 바위 =>2, 보=> 3 : ");
		Random r = new Random();
		int user = sc.nextInt();
		int com = r.nextInt(3) + 1;
		System.out.println(com);
		int score = user - com;

		if (user <= 0 || user >= 4) {
			System.out.println("잘못된 값을 입력했습니다.");
		} else if (score == 1 || score == -2) {
			System.out.println("승리했습니다!!");
		} else if (score == 0) {
			System.out.println("무승부입니다!");
		} else if (score == -1 || score == 2) {
			System.out.println("뿌엥...패배했습니다 ㅠㅠ");
		}
	}

}
