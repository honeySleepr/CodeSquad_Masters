package cs07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
1. 서로 동작 시간이 다른 프로세스 5개를 생성한다
2. 랜덤 3개를 선정한다
3. 실행 데크에 넣는다
4. 순차적으로 1초씩 실행한다
    - 순서대로 runTime을 +1 씩 해준다
5. 1초 마다 전체 프로세스 상태를 출력한다
    - 메인스레드를 1초간 멈추게 해야한다. Thread.sleep(1000) ?
6. runTime == lifeTime 된 프로세스는 status 를 terminated 로 바꾼다
7. terminated 된 프로세스는 실행하지 않는다
8. 모든 프로세스가 terminated 되면 종료

private final NEW = "생성됨";
private final WAITING = "대기중";
*/
public class Scheduller {
    private final String READY = "ready";
    private final String WAIT = "waiting";
    private final String RUN = "running";
    private final String END = "terminated";
    protected final Queue<myProcess> readyQueue = new ArrayDeque<>();
    protected final Queue<myProcess> waitingQueue = new ArrayDeque<>();
    protected final Queue<myProcess> runningQueue = new ArrayDeque<>(1);
    protected final Queue<myProcess> terminatedQueue = new ArrayDeque<>();
    private final List<Queue<myProcess>> process = new ArrayList<>();

    public Scheduller() {
        process.add(readyQueue);
        process.add(waitingQueue);
        process.add(runningQueue);
        process.add(terminatedQueue);
    }

    public void startSchedule() {
        //첫 프로세스 실행
        if(!readyQueue.isEmpty() && runningQueue.isEmpty()){
            readyToRunning();
            return;
        }
        // 두번째 부터 마지막 프로세스 까지
        if(!readyQueue.isEmpty()){
            runningToWaiting();
            readyToRunning();
            return;
        }
        // if(waitingQueue.isEmpty()){
        //     prepareWaitingQueue();
        //     startRunningProcess();
        // }
        if(!runningQueue.isEmpty()) {
            rotateRunningProcess();
        }


    }

    private void readyToRunning(){
        readyQueue.peek().setStatus(RUN);
        runningQueue.add(readyQueue.poll());
        runningQueue.peek().updateCurrentRunTime();
    }
    private void runningToWaiting(){
        if(runningQueue.peek().isDone()){
            runningToTerminated();
            return;
        }
        runningQueue.peek().setStatus(WAIT);
        waitingQueue.add(runningQueue.poll());
    }

    private void runningToTerminated() {
        runningQueue.peek().setStatus(END);
        terminatedQueue.add(runningQueue.poll());
    }

    public void loadProcess(List<myProcess> newMyProcesses) {
        for (int i = 0; i < 3; i++) {
            newMyProcesses.get(i).setStatus("ready");
            readyQueue.add(newMyProcesses.get(i));
        }
    }
    public void prepareWaitingQueue() {
        while (readyQueue.peek() != null) {
            readyQueue.element().setStatus(WAIT);
            waitingQueue.add(readyQueue.poll());
        }
    }

    public void startRunningProcess() {
        runningQueue.add(waitingQueue.poll());
        runningQueue.peek().setStatus(RUN);
        runningQueue.peek().updateCurrentRunTime();
    }

    private void rotateRunningProcess() {
        // runTime 끝났으면 terminated 으로 이동
        if(runningQueue.peek().isDone()){
            runningToTerminated();
            return;
        }
        // 실행 중이었던 프로세스를 대기 중으로 옮긴다
        runningQueue.peek().setStatus(WAIT);
        waitingQueue.add(runningQueue.poll());
        // 다음 차례인 프로세스를 실행한다
        runningQueue.add(waitingQueue.poll());
        runningQueue.peek().setStatus(RUN);
        runningQueue.peek().updateCurrentRunTime();
    }

}
