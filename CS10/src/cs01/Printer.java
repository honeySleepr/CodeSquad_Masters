package cs01;

import java.util.Arrays;

public class Printer {

    void printMission2Binary(String[] input, String[] halfBinary, String[] fullBinary) {

        System.out.println("bitA = "+input[0]);
        System.out.println("bitB = "+input[1]);
        System.out.println("carry = "+input[2]);
        System.out.println("반가산 결과 = "+Arrays.toString(halfBinary));
        System.out.println("전가산 결과 = "+Arrays.toString(fullBinary));
    }
    void printMission2Boolean(boolean[] bits, boolean[] half, boolean[] full) {

        System.out.println("bitA = "+bits[0]);
        System.out.println("bitB = "+bits[1]);
        System.out.println("carry = "+bits[2]);
        System.out.println("반가산 결과 = "+Arrays.toString(half));
        System.out.println("전가산 결과 = "+Arrays.toString(full));
    }

}
