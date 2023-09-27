package ddit.chapter08.sec01;
//09.04.2
// 고객센터에 전화가  걸려오면 대기열에 저장된다
// 걸려온 전화는 상담원이 배분되기 전까지 대기상태에 있다
// 전화를 상담원에게 분배하는 정책은
// 1) 순서대로 배분 (RoundRoin)
// 2) 짧은 대기열에 배분 (LeastJob) : 상담하지 않고 있는 상담원이나 대기 전화의 수가 가장 짧은 상담원에게 배분
// 3) 우선순위에 따른 배분 (PriorityAllocation): 고객의 등급에 따라 등급이 높은 고객상담부터 처리
public interface Scheduler {
	void getNextCall(); 	//상담대기열(전화)에서 상담전화를 가져옴
	void sendCallToAgent();	//다음 상담원에게 분배
}
