package cs07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memory {
    private final Scheduler scheduler;

    private final List<MyProcess> newMyProcesses = new ArrayList<>();

    public Memory(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void loadMemory() {
        createProcess();
        scheduler.loadProcess(newMyProcesses);
    }

    protected void createProcess() {
        newMyProcesses.add(new MyProcess("프로세스A", 3));
        newMyProcesses.add(new MyProcess("프로세스B", 5));
        newMyProcesses.add(new MyProcess("프로세스C", 7));
        newMyProcesses.add(new MyProcess("프로세스D", 10));
        newMyProcesses.add(new MyProcess("프로세스E", 15));
        Collections.shuffle(newMyProcesses);
    }

}
