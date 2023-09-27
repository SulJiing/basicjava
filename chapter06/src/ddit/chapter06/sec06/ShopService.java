package ddit.chapter06.sec06;

public class ShopService {
	private static ShopService instance = null;
	
	private ShopService() {
		
	}
	public static ShopService getInstance() {
		return instance;
	}
	
}

