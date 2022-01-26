package cs07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

    // 처음에는 Queue 들을 ArrayDeque 로 생성하였으나,
    // head만 꺼낼거라면 굳이 Deque 를 쓸 이유가 없지 않느냐는
    // @Riako,@Shine 의 조언을 듣고 LinkedList 로 바꾸었다.

    protected final Queue<MyProcess> readyQueue = new LinkedList<>();
    protected final Queue<MyProcess> waitingQueue = new LinkedList<>();
    protected final Queue<MyProcess> runningQueue = new LinkedList<>();
    protected final Queue<MyProcess> terminatedQueue = new LinkedList<>();
    protected final List<Queue<MyProcess>> process = new ArrayList<>();

    public Scheduler() {
        process.add(readyQueue);
        process.add(waitingQueue);
        process.add(runningQueue);
        process.add(terminatedQueue);
    }

    public void runScheduler() {
        //첫 프로세스 실행
        if (!readyQueue.isEmpty() && runningQueue.isEmpty()) {
            readyToRunning();
            return;
        }
        // 두번째 부터 readyQueue 소진할 때 까지 실행
        if (!readyQueue.isEmpty()) {
            runningToWaiting();
            readyToRunning();
            return;
        }
        // readyQueue 소진된 이후로 끝까지 실행
        if (!runningQueue.isEmpty()) {
            runningToWaiting();
            waitingToRunning();
        }
    }

    // start()를 이미 했던 스레드를 또 start()하면
    // IllegalThreadStateException 에러가 뜨기 때문에
    // 실행이 끝난 스레드를 전부 삭제(myThreadList.clear()) 한 뒤
    // 스레드를 다시 생성(setThread()) 해주었다.
    private void runProcess(MyProcess myProcess) {
        runningQueue.add(myProcess);
        for (MyThread thread : myProcess.myThreadList) {
            thread.start();
        }
        for (MyThread thread : myProcess.myThreadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        myProcess.myThreadList.clear();
        myProcess.setThread();
    }

    private void readyToRunning() {
        readyQueue.peek().setStatus(Status.RUN.getMessage());
        runProcess(readyQueue.poll());
    }

    private void runningToWaiting() {
        if (runningQueue.peek().isDone()) {
            runningToTerminated();
            return;
        }
        runningQueue.peek().setStatus(Status.WAIT.getMessage());
        waitingQueue.add(runningQueue.poll());
    }

    private void runningToTerminated() {
        runningQueue.peek().setStatus(Status.END.getMessage());
        terminatedQueue.add(runningQueue.poll());
    }

    private void waitingToRunning() {
        if (waitingQueue.isEmpty()) {
            return;
        }
        waitingQueue.peek().setStatus(Status.RUN.getMessage());
        runProcess(waitingQueue.poll());

    }

    public void loadProcess(List<MyProcess> newMyProcesses) {
        for (int i = 0; i < 3; i++) {
            MyProcess myProcess = newMyProcesses.get(i);
            myProcess.setStatus(Status.READY.getMessage());
            readyQueue.add(newMyProcesses.get(i));
        }
    }

}
