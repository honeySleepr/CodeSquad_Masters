package cs06;

import java.util.HashSet;
import java.util.Set;

public class PrimeAlpha extends Alpha {

    public PrimeAlpha(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        Set primeSet = new HashSet(){ {add(1); add(number);} };
        return number > 1 && factors().equals(primeSet);
    }


	public static void main(String[] args) {	
        PrimeAlpha prime1 = new PrimeAlpha(10);
        PrimeAlpha prime2 = new PrimeAlpha(7);

        System.out.println(prime1.isPrime());
        System.out.println(prime2.isPrime());
	}
}cd