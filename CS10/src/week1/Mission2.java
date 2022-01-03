package week1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Mission2 {
    static Map<String, Boolean> inputConvertor = Map.of("1", true, "0", false);
    static Map<Boolean, String> outputConvertor = Map.of(true, "1", false, "0");

    public static void main(String[] args) {
        /* binary 로 출력하려면 toBinary = true 로 변경*/
        boolean toBinary = false;
        boolean[] bits = convertInput();

        Logic logic = new Logic();
        boolean[] half = logic.halfAdder(bits[0], bits[1]);
        boolean[] full = logic.fullAdder(bits[0], bits[1], bits[2]);

        printResult(bits, half, full, toBinary);
    }

    private static boolean[] convertInput() {
        Scanner sc = new Scanner(System.in);
        String[] input = new String[3];

        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextLine();
        }
        boolean[] bits = new boolean[input.length];

        for (int i = 0; i < bits.length; i++) {
            bits[i] = inputConvertor.get(input[i]);
        }
        return bits;
    }

    private static String[] convertOutput(boolean[] answer) {
        String[] bytes = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            bytes[i] = outputConvertor.get(answer[i]);
        }
        return bytes;
    }

    private static void printResult(boolean[] bits, boolean[] half, boolean[] full, boolean toBinary) {
        System.out.println("bitA = " + bits[0]);
        System.out.println("bitB = " + bits[1]);
        System.out.println("carry = " + bits[2]);
        if (toBinary) {
            System.out.println("반가산 결과 = " + Arrays.toString(convertOutput(half)));
            System.out.println("전가산 결과 = " + Arrays.toString(convertOutput(full)));
        } else {
            System.out.println("반가산 결과 = " + Arrays.toString(half));
            System.out.println("전가산 결과 = " + Arrays.toString(full));
        }
    }
}