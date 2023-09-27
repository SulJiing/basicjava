package ddit.chater05.sec06;
//09.01
public class Developer {

	String name;
	int career;
	public DeviceType type;
	static Developer d = new Developer();

	public static void main(String[] args) {
		getInfo();
		getDeviceType();
	}

	public static void getInfo() {
		d.name = "정몽주";
		d.career = 5;
		d.type = DeviceType.SERVER;

		System.out.println("개발자명 : " + d.name);
		System.out.println("개발경력 : " + d.career);
		System.out.println("직무파트 : " + d.type);
	}

	public static void getDeviceType() {
		for (DeviceType dev : DeviceType.values()) {
			System.out.println(dev.getName());
		}
		DeviceType dp = d.type.WEB;
		System.out.println(dp.ordinal());
	}

}
