package cs01;

import java.util.List;

public class Mission {
    Adder adder;
    Printer printer;
    Convertor convertor;

    Mission(Adder adder, Printer printer, Convertor convertor) {
        this.adder = adder;
        this.printer = printer;
        this.convertor = convertor;
        boolean toBinary = true;
        runMission2("011", toBinary);
        runMission3("0001110", "1011", toBinary);
        runMission4(175,"1100001");
    }

    private List<String[]> runMission2(String input, boolean toBinary) {
        boolean[] bits = convertor.convertInput(input.split(""));

        boolean bitA = bits[0];
        boolean bitB = bits[1];
        boolean carry = bits[2];

        boolean[] half = adder.halfAdder(bitA, bitB);
        boolean[] full = adder.fullAdder(bitA, bitB, carry);

        if (toBinary) {
            String[] halfBinary = convertor.getBinaryResult(half);
            String[] fullBinary = convertor.getBinaryResult(full);
            String[] bitsBinary = convertor.getBinaryResult(bits);
            return printer.printMission2(bitsBinary, halfBinary, fullBinary);
        } else {
            printer.printMission2(bits, half, full);
            return null;
        }
    }

    private List<String> runMission3(String input1, String input2,
        boolean toBinary) {

        boolean[] byteA = convertor.convertInput(input1.split(""));
        boolean[] byteB = convertor.convertInput(input2.split(""));
        boolean[] sum = adder.byteAdder(byteA, byteB);

        if (toBinary) {
            String[] binarySum = convertor.getBinaryResult(sum);
            String[] binaryByteA = convertor.getBinaryResult(byteA);
            String[] binaryByteB = convertor.getBinaryResult(byteB);
            return printer.printMission3(binarySum, binaryByteA, binaryByteB);
        } else {
            printer.printMission3(sum, byteA, byteB);
            return null;
        }
    }

    private List<String> runMission4(int intInput, String binaryInput) {

        boolean[] binary = convertor.dec2bin(intInput);
        String[] binaryAnswer = convertor.getBinaryResult(binary);
        int decimal = convertor.bin2dec(binaryInput);

        return printer.printMission4(binaryAnswer, decimal);
    }
}
