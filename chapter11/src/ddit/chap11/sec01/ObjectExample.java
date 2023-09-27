package ddit.chap11.sec01;
//09.08.02
public class ObjectExample {

	public static void main(String[] args) {
		ObjectClass obj1 = new ObjectClass("홍길동","1234");
		ObjectClass obj2 = new ObjectClass("홍길동","1235");
//		obj1=obj2;
		
		if(obj1.equals(obj2) && obj1.hashCode()==obj2.hashCode()) {//주소가 비교됨
			System.out.println("동일객체");
			System.exit(0);//바로 종료
		} else {
			System.out.println("서로 다른 객체");
		}
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println("obj1 = "+obj1);
		
		String str1 = "홍길동";
		if(str1.equals("홍길동")) {
			System.out.println("11동일객체");
		} else {
			System.out.println("서로 다른 객체");
		}
	}
}
class ObjectClass{
	String name;
	String id;
	
	public ObjectClass(String name, String id) {
		this.name=name;
		this.id=id;
	}
	@Override //이퀄스 재정의
	public boolean equals(Object obj) {
		if(obj instanceof ObjectClass) {
			ObjectClass object = (ObjectClass)obj;
			if(name.equals(object.name)) {
				return true;
			}
		}
		return false;
	}
	@Override //해시코드 재정의
	public int hashCode() {
		return id.hashCode();
	}
	@Override //투스트링 재정의
	public String toString() {
//		return getClass().getName()+"@"+Integer.toHexString(hashCode());
		return id+", "+name;
	}
}
