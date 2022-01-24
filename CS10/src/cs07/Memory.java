package cs07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memory {
    private final Scheduller scheduller;

    private final List<myProcess> newMyProcesses = new ArrayList<>();

    public Memory(Scheduller scheduller) {
        this.scheduller = scheduller;
    }

    public void loadMemory() {
        createProcess();
        scheduller.loadProcess(newMyProcesses);
    }

    protected void createProcess() {
        newMyProcesses.add(new myProcess("프로세스A", 3));
        newMyProcesses.add(new myProcess("프로세스B", 5));
        newMyProcesses.add(new myProcess("프로세스C", 7));
        newMyProcesses.add(new myProcess("프로세스D", 10));
        newMyProcesses.add(new myProcess("프로세스E", 15));
        Collections.shuffle(newMyProcesses);
    }

}
