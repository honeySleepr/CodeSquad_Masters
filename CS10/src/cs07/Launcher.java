package cs07;

import java.util.ArrayDeque;
import java.util.Queue;

public class Launcher {
    public static void main(String[] args) {
        Scheduller scheduller = new Scheduller();
        Memory memory = new Memory(scheduller);
        Print print = new Print();
        Controller controller = new Controller(scheduller,memory, print);
        controller.start();
        Queue<myProcess> qqqq = new ArrayDeque<>();
    }
}
