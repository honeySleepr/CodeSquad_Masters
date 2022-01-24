package cs07;

public class Controller {
    private final Scheduler scheduler;
    private final Memory memory;
    private final Printer printer;

    public Controller(Scheduler scheduler, Memory memory, Printer printer) {
        this.scheduler = scheduler;
        this.memory = memory;
        this.printer = printer;
    }

    public void start() {
        memory.loadMemory();
        printer.printInitStatus(scheduler.readyQueue);
        processLoop();
    }

    public void processLoop() {
        int count = scheduler.readyQueue.size();
        while (scheduler.terminatedQueue.size() < count) {
            System.out.println("----------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            scheduler.runScheduler();
            printer.printRunningStatus(scheduler.process);
        }
        System.out.println("모든 프로세스 종료");
    }
}
