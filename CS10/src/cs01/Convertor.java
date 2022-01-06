package cs01;

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

}
