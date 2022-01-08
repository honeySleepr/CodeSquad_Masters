package cs01;

import java.util.Arrays;
import java.util.stream.Stream;

public class Mission {
    Adder adder;
    Printer printer;
    Convertor convertor;
    boolean toBinary = false;

    Mission(Adder adder, Printer printer, Convertor convertor) {
        this.adder = adder;
        this.printer = printer;
        this.convertor = convertor;

        runMission2();
        runMission3();
        runMission4();
    }

    private void runMission2() {
        boolean bitA, bitB, carry;
        String[] input = {"1", "1", "1"};
        boolean[] bits = convertor.convertInput(input);

        bitA = bits[0];
        bitB = bits[1];
        carry = bits[2];

        boolean[] half = adder.halfAdder(bitA, bitB);
        boolean[] full = adder.fullAdder(bitA, bitB, carry);

        System.out.println("------Mission 2------");
        if (toBinary) {
            String[] halfBinary = convertor.getBinaryResult(half);
            String[] fullBinary = convertor.getBinaryResult(full);
            printer.printMission2Binary(input,halfBinary,fullBinary);
        } else{
            printer.printMission2Boolean(bits, half, full);
        }

    }

    private void runMission3() {

        String input1 = "111";
        String input2 = "01001";

        String[] byteA = input1.split("");
        String[] byteB = input2.split("");

        boolean[] booleanByteA = convertor.convertInput(byteA);
        boolean[] booleanByteB = convertor.convertInput(byteB);

        boolean[] answer = adder.byteAdder(booleanByteA, booleanByteB);

        System.out.println("\n------Mission 3------");
        if (toBinary) {
            String[] binaryAnswer = convertor.getBinaryResult(answer);
            Arrays.stream(binaryAnswer).forEach(System.out::print);
        }else{
            System.out.println(Arrays.toString(answer));
        }
    }

    private void runMission4() {

        boolean[] binary = convertor.dec2bin(173);
        String[] binaryAnswer = convertor.getBinaryResult(binary);
        int decimal = convertor.bin2dec("0101");

        System.out.println("\n------Mission 4------");
        System.out.println("dec2bin : " + Arrays.toString(binaryAnswer).replace("[","").replace("]","").replace(", ",""));
        System.out.println("bin2dec : " + decimal);
    }
}
