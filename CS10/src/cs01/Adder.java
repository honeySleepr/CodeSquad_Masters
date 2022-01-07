package cs01;

import java.util.Arrays;

public class Adder extends LogicGate {

    boolean[] halfAdder(boolean a, boolean b) {
        return new boolean[] {carry(a, b), sum(a, b)};
    }

    boolean[] fullAdder(boolean a, boolean b, boolean c) {
        boolean halfSum1 = halfAdder(a, b)[1];
        boolean halfSum2 = halfAdder(halfSum1, c)[1];

        boolean halfCarry1 = halfAdder(a, b)[0];
        boolean halfCarry2 = halfAdder(halfSum1, c)[0];

        boolean carry = or(halfCarry1, halfCarry2);
        boolean sum = halfSum2;

        return new boolean[] {carry, sum};
    }

    boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int maxLength = Math.max(byteA.length, byteB.length);
        boolean[] answer = new boolean[maxLength + 1];

        byteA = matchSize(byteA, maxLength);
        byteB = matchSize(byteB, maxLength);

        boolean bitC = false;

        for (int i = 0; i < answer.length - 1; i++) {
            answer[i] = fullAdder(byteA[i], byteB[i], bitC)[1];
            bitC = fullAdder(byteA[i], byteB[i], bitC)[0];
        }
        answer[answer.length - 1] = bitC;

        return answer;
    }

    private boolean[] matchSize(boolean[] bytes, int maxLength) {
        if (bytes.length != maxLength) {

            boolean[] temp = new boolean[maxLength];
            Arrays.fill(temp, false);

            for (int i = 0; i < bytes.length; i++) {
                temp[i] = bytes[i];
            }
            return temp;
        } else {
            return bytes;
        }
    }
}
