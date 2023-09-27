package ddit.chapter08.sec01;
//09.04.2
public class PriorityAllocation implements Scheduler {
	// 3) 우선순위에 따른 배분 (PriorityAllocation): 고객의 등급에 따라 등급이 높은 고객상담부터 처리
	@Override
	public void getNextCall() {
		System.out.println("고객의 등급을 비교하여 가장 높은 등급의 고객전화를 가져온다.");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("업무수행 능력이 우수한 사원부터 대기열 앞의 상담전화를 분배한다.");
	}
}
