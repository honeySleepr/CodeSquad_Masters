package cs04;

public class Launcher {
    public static void main(String[] args) {
        Controller control = new Controller(new Input(), new Point());
        control.start();
    }
}
