package cs01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Convertor {

    Map<String, Boolean> binaryToBoolean = Map.of("1", true, "0", false);
    Map<Boolean, String> booleanToBinary = Map.of(true, "1", false, "0");

    boolean[] convertInput(String[] input) {

        boolean[] booleans = new boolean[input.length];

        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = binaryToBoolean.get(input[i]);
        }
        return booleans;
    }

    String[] getBinaryResult(boolean[] bits) {
        String[] binary = new String[bits.length];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = booleanToBinary.get(bits[i]);
        }
        return binary;
    }


    boolean[] dec2bin(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num - (num / 2) * 2);   // num % 2 와 같다
            num /= 2;
        }
        boolean[] answer = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = (list.get(i) == 1);
        }
        return answer;
    }

    int bin2dec(String binary) {
        int answer = 0;
        int powerOf2 = 1;
        for (int i = 0; i < binary.length(); i++) {
            answer += (binary.charAt(i) - '0') * powerOf2;
            powerOf2 *= 2;
        }
        return answer;
    }
}
