package cs01;

public class Launch {
    public static void main(String[] args) {
        new Mission(new Adder(), new Printer(),new Convertor());
    }
}
