package ddit.chater05.sec02;
//08.24
public class ArrayExample05 {

	public static void main(String[] args) {
		// �ִ밪, �ּڰ� ���ϱ�
		int[] num = { 15, 23, 7, 85, 66, 27, 10 };

		int tmin = num[0]; // �ӽ� �ּڰ�
		int tmax = num[0]; // �ӽ� �ִ밪

		for (int i = 1; i < num.length - 1; i++) {
			// �ּڰ�
			if (tmin > num[i]) {
				tmin = num[i];
			}
			// �ִ밪
			if (tmax < num[i]) {
				tmax = num[i];
			}

		}
		System.out.println("�ּҰ��� =" + tmin);
		System.out.println("�ִ밪�� =" + tmax);
	}

}
