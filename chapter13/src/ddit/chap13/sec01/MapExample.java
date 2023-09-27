package ddit.chap13.sec01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//09.08.08
public class MapExample {

	public static void main(String[] args) {
		Map <String, Integer> map = new HashMap<String, Integer>();
		// 데이터 삽입
		map.put("홍길동", 28);
		map.put("정몽주", 18);
		map.put("이순신", 32);
		map.put("강감찬", 13);
		map.put("송시열", 22);
		
		// 조회
		System.out.println(map.get("송시열"));
		
		Set<String> keySet=map.keySet();
		
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println("key : "+key+", value : "+value);
		}
	}

}
