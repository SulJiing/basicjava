package ddit.chap02.sec03;

public class EscapeExample {

	public static void main(String[] args) {
		String str1="ȫ�浿";
		String str2="ȫ���";
		String str3="������";
		
		System.out.println(str1);
		System.out.println(str1+"�� \n�� ģ���Դϴ�..");
		System.out.println(str1+"�� \r�� ģ���Դϴ�..");
		System.out.println();							//ln�� ���� �ٲٶ�� ���̱� ������ ��ĭ�� �����
		System.out.println(str1+"\""+str3+"\"");
		System.out.println(str1+"\'"+str3+"\'");
		System.out.println(str1+"\\"+str3+"\\");
		System.out.println(str1+"��\n\n�� ģ���Դϴ�.");
		System.out.println(str3+"��\r\n�� ģ���Դϴ�..");
		System.out.println("\u0041");
		System.out.println("\u0061");
		System.out.println("\uAC00");

	}

}
