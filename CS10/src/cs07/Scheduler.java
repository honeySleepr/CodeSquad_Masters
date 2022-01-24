package cs07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Scheduler {
    //enum 활용?
    private final String READY = "ready";
    private final String WAIT = "waiting";
    private final String RUN = "running";
    private final String END = "terminated";
    protected final Queue<myProcess> readyQueue = new ArrayDeque<>();
    protected final Queue<myProcess> waitingQueue = new ArrayDeque<>();
    protected final Queue<myProcess> runningQueue = new ArrayDeque<>(1);
    protected final Queue<myProcess> terminatedQueue = new ArrayDeque<>();
    protected final List<Queue<myProcess>> process = new ArrayList<>();

    public Scheduler() {
        process.add(readyQueue);
        process.add(waitingQueue);
        process.add(runningQueue);
        process.add(terminatedQueue);
    }

    public void runScheduler() {
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

        if(!runningQueue.isEmpty()) {
            runningToWaiting();
            waitingToRunning();
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

    private void waitingToRunning(){
        if(waitingQueue.isEmpty()){
            return;
        }
        waitingQueue.peek().setStatus(RUN);
        runningQueue.add(waitingQueue.poll());
        runningQueue.peek().updateCurrentRunTime();
    }

    public void loadProcess(List<myProcess> newMyProcesses) {
        for (int i = 0; i < 3; i++) {
            newMyProcesses.get(i).setStatus(READY);
            readyQueue.add(newMyProcesses.get(i));
        }
    }


}
