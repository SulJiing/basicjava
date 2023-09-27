package ddit.chapter08.sec01;
//09.04.2
public class RoundRoin implements Scheduler {
	// 1) 순서대로 배분 (RoundRoin)
	@Override
	public void getNextCall() {
		System.out.println("다음 상담 전화는 대기열에서 차례대로 가져온다.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("대기열에서 기져온 전화를 다음 상담원에게 차례대로 분배한다.");
	}
}
