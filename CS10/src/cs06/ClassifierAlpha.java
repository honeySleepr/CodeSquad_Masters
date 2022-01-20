package cs06;

import java.util.Set;

public class ClassifierAlpha extends Alpha {

    public ClassifierAlpha(int number) {
        this.number = number;
    }

    static public int sum(Set<Integer> factors) {
        return factors.stream()
            .reduce(0,(x, y) -> x + y);

    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }

    public static void main(String[] args) {
        ClassifierAlpha alpha1 = new ClassifierAlpha(10);
        ClassifierAlpha alpha2 = new ClassifierAlpha(6);

        System.out.println(alpha1.isPerfect());
        System.out.println(alpha2.isPerfect());
    }
}