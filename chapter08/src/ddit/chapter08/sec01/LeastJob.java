package ddit.chapter08.sec01;
//09.04.2
public class LeastJob implements Scheduler {
	// 2) 짧은 대기열에 배분 (LeastJob) : 상담하지 않고 있는 상담원이나 대기 전화의 수가 가장 짧은 상담원에게 배분
	@Override
	public void getNextCall() {
		System.out.println("다음 상담 전화는 대기열에서 차례대로 가져온다.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("현재 상담하지 않는 상담원에게 배분하거나 모든 상담원이 상담 중이라면 대기열이 가장 짧은 상담원에게 분배한다.");
	}
}
