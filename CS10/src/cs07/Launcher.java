package cs07;

public class Launcher {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Memory memory = new Memory(scheduler);
        Printer printer = new Printer();
        Controller controller = new Controller(scheduler,memory, printer);
        controller.start();
    }
}
