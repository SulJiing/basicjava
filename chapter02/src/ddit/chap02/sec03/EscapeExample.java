package ddit.chap02.sec03;

public class EscapeExample {

	public static void main(String[] args) {
		String str1="홍길동";
		String str2="홍길순";
		String str3="정몽주";
		
		System.out.println(str1);
		System.out.println(str1+"은 \n내 친구입니다..");
		System.out.println(str1+"은 \r내 친구입니다..");
		System.out.println();							//ln이 줄을 바꾸라는 뜻이기 때문에 한칸이 띄어짐
		System.out.println(str1+"\""+str3+"\"");
		System.out.println(str1+"\'"+str3+"\'");
		System.out.println(str1+"\\"+str3+"\\");
		System.out.println(str1+"은\n\n내 친구입니다.");
		System.out.println(str3+"는\r\n내 친구입니다..");
		System.out.println("\u0041");
		System.out.println("\u0061");
		System.out.println("\uAC00");

	}

}
