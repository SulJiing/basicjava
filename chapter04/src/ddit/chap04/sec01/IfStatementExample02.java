package ddit.chap04.sec01;

import java.util.Scanner;

// if 02 08.17
public class IfStatementExample02 {

	public static void main(String[] args) {
		// 키와 체중을 각각 m과 kg으로 입력받아 BMI지수를 계산하고
		// 계산된 BMI 지수가 0 ~ 18.4 : 저체중 / 18.5 ~ 22.9 : 정상체중
		// 23.0 ~ 24.9 : 과체중 / 25.0 ~ 29.9 : 비만 / 30.0 이상 : 고도비만 을 출력하시오
		// BMI 지수 = 체중(kg) / (키(m) * 키(m))
		Scanner sc = new Scanner(System.in);
		System.out.print("키 입력 (m) : ");
		double m = sc.nextDouble();
		System.out.print("체중 입력 (kg) : ");
		double kg = sc.nextDouble();

		// double changeMitter = (double) m / 100;
		// double bmi = kg / (changeMitter * changeMitter);
		// System.err.printf("%.1f\n", bmi);
		// - %.1f 적힌 소수점 자릿수까지 반올림
		double bmi = kg / (m * m);
		bmi = (int) (bmi * 10 + 0.5) / 10.;
		// 둘째자리에서 반올림이기 때문에 10을 곱하고 0.5를 더한 것 그리고 10을 곱했기 때문에 10을 다시 나눠준 것
		// (int)를 붙힌 이유는 그 나머지 소수점 이하 자리를 떼어내기 위함
		// int는 정수이기 때문에 소수점 자리가 0으로 나옴 그래서 10뒤에 .을 찍거나 앞에 (double)를 붙혀야 함
		System.out.println("BMI지수 : " + bmi);
		String message = "";
		if (bmi < 18.5) {
			message = "저체중";
		} else if (bmi < 23.0) {
			message = "정상체중";
		} else if (bmi < 25.0) {
			message = "과체중";
		} else if (bmi < 30.0) {
			message = "비만";
		} else if (bmi >= 30.0) {
			message = "고도비만";
		}
		System.out.println("키 " + m + "m와 체중" + kg + "kg은" + message + "입니다.\nBMI 지수는" + bmi + " 입니다.");
		System.out.printf("BMI 지수 : %.1f", bmi);
	}
}
