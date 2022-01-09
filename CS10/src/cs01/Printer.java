package cs01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer {

    void printMission2(boolean[] bits, boolean[] half,
        boolean[] full) {
        System.out.println("------Mission 2------");
        System.out.println("bitA = " + bits[0]);
        System.out.println("bitB = " + bits[1]);
        System.out.println("carry = " + bits[2]);
        System.out.println("반가산 결과 = " + Arrays.toString(half));
        System.out.println("전가산 결과 = " + Arrays.toString(full));
    }

    List<String[]> printMission2(String[] bits, String[] half, String[] full) {
        System.out.println("------Mission 2------");
        System.out.println("bitA = " + bits[0]);
        System.out.println("bitB = " + bits[1]);
        System.out.println("carry = " + bits[2]);
        System.out.println("반가산 결과 = " + Arrays.toString(half));
        System.out.println("전가산 결과 = " + Arrays.toString(full));

        return new ArrayList<>(List.of(bits, half, full));
    }

    void printMission3(boolean[] sum, boolean[] byteA, boolean[] byteB) {
        System.out.println("------Mission 3------");
        System.out.println("byteA  = " + Arrays.toString(byteA));
        System.out.println("byteB  = " + Arrays.toString(byteB));
        System.out.println(Arrays.toString(sum));
    }

    List<String> printMission3(String[] sum, String[] byteA, String[] byteB) {
        System.out.println("------Mission 3------");
        System.out.print("byteA  = ");
        Arrays.stream(byteA).forEach(System.out::print);
        System.out.print("\nbyteB  = ");
        Arrays.stream(byteB).forEach(System.out::print);
        System.out.print("\nAnswer = ");
        Arrays.stream(sum).forEach(System.out::print);
        System.out.println();

        return new ArrayList<>(List.of(Arrays.toString(byteA),
            Arrays.toString(byteB), Arrays.toString(sum)));
    }

    List<String> printMission4(String[] binaryAnswer, int decimal) {
        System.out.println("------Mission 4------");
        System.out.print("dec2bin : ");
        Arrays.stream(binaryAnswer).forEach(System.out::print);
        System.out.println();
        System.out.println("bin2dec : " + decimal);

        return new ArrayList<>(List.of(Arrays.toString(binaryAnswer),
            Integer.toString(decimal)));
    }

}
