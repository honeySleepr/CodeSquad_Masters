package week1;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    boolean sum(boolean a, boolean b) {
        return xor(a, b);
    }

    boolean carry(boolean a, boolean b) {
        return and(a, b);
    }

    boolean[] halfAdder(boolean a, boolean b) {
        boolean[] answer = {carry(a, b), sum(a, b)};
        return answer;
    }

    boolean[] fullAdder(boolean a, boolean b, boolean c) {
        boolean[] answer = {false, false};

        answer[0] = or(and(xor(a, b), c), and(a, b));
        answer[1] = xor(xor(a, b), c);

        return answer;
    }

    boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean[] answer = new boolean[byteA.length + 1];

        answer[0] = halfAdder(byteA[0], byteB[0])[1];
        boolean bitC = halfAdder(byteA[0], byteB[0])[0];

        for (int i = 1; i < answer.length - 1; i++) {

            answer[i] = fullAdder(byteA[i], byteB[i], bitC)[1];
            bitC = fullAdder(byteA[i], byteB[i], bitC)[0];
        }
        answer[answer.length - 1] = bitC;

        return answer;
    }

    boolean[] dec2bin(int decimal) {
        List<Integer> list = new ArrayList<>();

        while (decimal > 0) {
            list.add(decimal - (decimal / 2) * 2);   // decimal % 2 와 같다
            decimal /= 2;
        }
        boolean[] answer = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                answer[i] = true;
            } else {
                answer[i] = false;
            }
        }
        return answer;
    }


    int bin2dec(String binary) {
        int answer = 0;
        int powerOf2 = 1;
        for (int i = 0; i < binary.length(); i++) {
            answer += (binary.charAt(i)-'0') * powerOf2;
            powerOf2 *= 2;
        }
        return answer;
    }

    boolean and(boolean a, boolean b) {
        if (a && b) {
            return true;
        } else {
            return false;
        }
    }

    boolean nand(boolean a, boolean b) {
        if (!(a && b)) {
            return true;
        } else {
            return false;
        }
    }

    boolean or(boolean a, boolean b) {
        if (a || b) {
            return true;
        } else {
            return false;
        }
    }

    boolean xor(boolean a, boolean b) {
        if ((a || b) && !(a && b)) {
            return true;
        } else {
            return false;
        }

        // 위 방법 말고도 NOR 게이트를 5개 사용하거나, NAND 게이트를 4개 사용하는 방법(아래)도 있다
        // if (!(!(!(a && b) && a) && !(!(a && b) && b))){
        //     return true;
        // }else{
        //     return false;
        // }
    }
}
