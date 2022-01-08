package cs01;

public class Mission {
    Adder adder;
    Printer printer;
    Convertor convertor;
    static boolean toBinary = true;

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

        printer.printMission2(bits, half, full);
    }

    private void runMission3() {

        String input1 = "0001110";
        String input2 = "01001";

        String[] byteA = input1.split("");
        String[] byteB = input2.split("");

        boolean[] booleanByteA = convertor.convertInput(byteA);
        boolean[] booleanByteB = convertor.convertInput(byteB);

        boolean[] answer = adder.byteAdder(booleanByteA, booleanByteB);

        printer.printMission3(answer, booleanByteA, booleanByteB);

    }

    private void runMission4() {

        boolean[] binary = convertor.dec2bin(173);
        String[] binaryAnswer = convertor.getBinaryResult(binary);
        int decimal = convertor.bin2dec("0101");

        printer.printMission4(binaryAnswer, decimal);
    }
}
