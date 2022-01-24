package cs07;

public class myProcess {
    String name;
    String status;
    int lifeTime;
    int currentRunTime;

    public myProcess(String name, int lifeTime) {
        this.name = name;
        this.status = "new";
        this.lifeTime = lifeTime;
        this.currentRunTime = 0;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void updateCurrentRunTime() {
        this.currentRunTime += 1;
    }

    public boolean isDone() {
        return currentRunTime == lifeTime;
    }

    @Override
    public String toString() {
        return name.substring(name.length()-1) + "("
            + status + "), "
            + currentRunTime + " / "
            + lifeTime + "sec";
    }
}
