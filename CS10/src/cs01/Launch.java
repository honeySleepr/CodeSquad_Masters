package cs01;

public class Launch {
    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        new Mission(new Adder(), new Printer(convertor),convertor);
    }
}
