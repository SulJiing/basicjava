package ddit.chater05.sec06;

//09.01
public enum DeviceType {
	MOBLIE("�ȵ���̵�"), 
	WEB("������"), 
	SERVER("������");

	private final String name;

	private DeviceType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
