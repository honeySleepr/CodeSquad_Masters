package week1;

import java.util.Arrays;
import java.util.Map;

public class Mission4 {

    static Map<Boolean, String> convertor = Map.of(true, "1", false, "0");

    public static void main(String[] args) {

        boolean toBinary = true;

        Logic logic = new Logic();
        boolean[] binary = logic.dec2bin(173);
        int decimal = logic.bin2dec("11110101");

        System.out.print("dec2bin : ");
        printResult(binary, toBinary);

        System.out.println("bin2dec : "+ decimal);
    }

    private static String[] convertOutput(boolean[] answer) {
        String[] bytes = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            bytes[i] = convertor.get(answer[i]);
        }
        return bytes;
    }

    private static void printResult(boolean[] answer, boolean toBinary) {
        if (toBinary) {
            System.out.println(Arrays.toString(convertOutput(answer)));
        } else {
            System.out.println(Arrays.toString(answer));
        }
    }
}
