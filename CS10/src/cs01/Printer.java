package cs01;

import java.util.Arrays;

public class Printer {
    Convertor convertor;

    public Printer(Convertor convertor) {
        this.convertor = convertor;
    }

    void printMission2(boolean[] bits, boolean[] half, boolean[] full) {

        System.out.println("------Mission 2------");
        if (Mission.toBinary) {
            String[] halfBinary = convertor.getBinaryResult(half);
            String[] fullBinary = convertor.getBinaryResult(full);
            String[] bitsBinary = convertor.getBinaryResult(bits);
            System.out.println("bitA = " + bitsBinary[0]);
            System.out.println("bitB = " + bitsBinary[1]);
            System.out.println("carry = " + bitsBinary[2]);
            System.out.println("반가산 결과 = " + Arrays.toString(halfBinary));
            System.out.println("전가산 결과 = " + Arrays.toString(fullBinary));
        } else {
            System.out.println("bitA = " + bits[0]);
            System.out.println("bitB = " + bits[1]);
            System.out.println("carry = " + bits[2]);
            System.out.println("반가산 결과 = " + Arrays.toString(half));
            System.out.println("전가산 결과 = " + Arrays.toString(full));
        }
        System.out.println();
    }

    void printMission3(boolean[] answer, boolean[] byteA, boolean[] byteB) {
        System.out.println("------Mission 3------");

        if (Mission.toBinary) {
            String[] binaryAnswer = convertor.getBinaryResult(answer);
            String[] binaryByteA = convertor.getBinaryResult(byteA);
            String[] binaryByteB = convertor.getBinaryResult(byteB);
            System.out.print("byteA  = ");
            Arrays.stream(binaryByteA).forEach(System.out::print);
            System.out.println();
            System.out.print("byteB  = ");
            Arrays.stream(binaryByteB).forEach(System.out::print);
            System.out.println();
            System.out.print("Answer = ");
            Arrays.stream(binaryAnswer).forEach(System.out::print);
        } else {
            System.out.print("byteA  = ");
            System.out.println(Arrays.toString(byteA));
            System.out.println();
            System.out.print("byteB  = ");
            System.out.println(Arrays.toString(byteB));
            System.out.println();
            System.out.println(Arrays.toString(answer));
        }
        System.out.println();
    }

    void printMission4(String[] binaryAnswer, int decimal) {
        System.out.println("\n------Mission 4------");
        System.out.print("dec2bin : ");
        Arrays.stream(binaryAnswer).forEach(System.out::print);
        System.out.println();
        System.out.println("bin2dec : " + decimal);
    }
}
