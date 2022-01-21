package cs06;

import java.util.Random;
import java.util.function.Predicate;

public class PrimeAlpha extends Alpha {

    private Predicate<Integer> isPrime = (number) -> factors2.apply(number).size() == 2;

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            int random = new Random().nextInt(100) + 1;

            PrimeAlpha prime = new PrimeAlpha();

            System.out.println(random + "  :  " + prime.isPrime.test(random));
        }
    }
}