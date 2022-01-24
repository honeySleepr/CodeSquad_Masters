package cs07;

public class Controller {
    private final Scheduller scheduller;
    private final Memory memory;
    private final Print print;

    public Controller(Scheduller scheduller, Memory memory, Print print) {
        this.scheduller = scheduller;
        this.memory = memory;
        this.print = print;
    }

    public void start() {
        memory.loadMemory();
        print.printConsole(scheduller.readyQueue);

        while(! scheduller.runningQueue.isEmpty()) {
            scheduller.startSchedule();
        }
    }
}
