package cs01;

public class LogicGate {

    boolean sum(boolean a, boolean b) {
        return xor(a, b);
    }

    boolean carry(boolean a, boolean b) {
        return and(a, b);
    }


    boolean and(boolean a, boolean b) {
        return a && b;
    }

    boolean nand(boolean a, boolean b) {
        return !(a && b);
    }

    boolean or(boolean a, boolean b) {
        return a || b;
    }

    boolean xor(boolean a, boolean b) {
        return a != b;
    }
}
