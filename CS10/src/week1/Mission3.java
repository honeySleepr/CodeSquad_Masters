package week1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Mission3 {
    static Map<String, Boolean> inputConvertor = Map.of("1", true, "0", false);
    static Map<Boolean, String> outputConvertor = Map.of(true, "1", false, "0");

    public static void main(String[] args) {
        /* binary 로 출력하려면 toBinary = true 로 변경*/
        boolean toBinary = false;

        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split("");
        String[] input2 = sc.nextLine().split("");

        boolean[] byteA = convertInput(input1);
        boolean[] byteB = convertInput(input2);

        Logic logic = new Logic();
        boolean[] answer = logic.byteAdder(byteA, byteB);

        printResult(answer,toBinary);

    }

    private static boolean[] convertInput(String[] input) {

        boolean[] bytes = new boolean[input.length];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = inputConvertor.get(input[i]);
        }
        return bytes;
    }

    private static String[] convertOutput(boolean[] answer) {
        String[] bytes = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            bytes[i] = outputConvertor.get(answer[i]);
        }
        return bytes;
    }

   private static void printResult(boolean[] answer, boolean toBinary){
        if (toBinary) {
            System.out.println(Arrays.toString(convertOutput(answer)));
        } else {
            System.out.println(Arrays.toString(answer));
        }
    }
}
