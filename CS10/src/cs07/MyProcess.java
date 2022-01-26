package cs07;

import java.util.ArrayList;
import java.util.List;

public class MyProcess {
    String name;
    String status;
    int lifeTime;
    int currentRunTime;
    List<MyThread> myThreadList = new ArrayList<>();

    public MyProcess(String name, int lifeTime) {
        this.name = name;
        this.status = "new";
        this.lifeTime = lifeTime;
        this.currentRunTime = 0;
        setThread();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public synchronized void updateCurrentRunTime() { // join() 대신 synchronized
        int leftTime = lifeTime - currentRunTime;
        if(leftTime > 1) {
            this.currentRunTime += 2;
            return;
        }
        if(leftTime == 1){
            this.currentRunTime += 1;
        }
    }

    public boolean isDone() {
        return currentRunTime == lifeTime;
    }

    public void setThread(){
        for (int j = 0; j < this.lifeTime / 2; j++) {
            this.myThreadList.add(new MyThread(this));
        }
    }

    @Override
    public String toString() {
        return name.substring(name.length() - 1) + "("
            + status + "), "
            + currentRunTime + " / "
            + lifeTime + "sec";
    }
}
