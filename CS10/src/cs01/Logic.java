package cs01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logic {

    boolean sum(boolean a, boolean b) {
        return xor(a, b);
    }

    boolean carry(boolean a, boolean b) {
        return and(a, b);
    }

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
            Arrays.fill(temp,false);

            for (int i = 0; i < bytes.length; i++) {
                temp[i] = bytes[i];
            }
            return temp;
        } else {
            return bytes;
        }
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

    boolean and(boolean a, boolean b) {
        return a && b;
    }

    boolean nand(boolean a, boolean b) {
        return !(a && b);
    }

    boolean or(boolean a, boolean b) {
        return a || b;
    }

    boolean xor(boolean a, boolean b) {
        return a != b;
    }
}
