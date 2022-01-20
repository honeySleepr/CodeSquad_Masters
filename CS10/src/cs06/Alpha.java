package cs06;

import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alpha {
    public int number;

    IntPredicate isFactor = i -> number % i == 0;

    public Set<Integer> factors() {
        return IntStream.rangeClosed(1, number)
            .filter(isFactor)
            .boxed().collect(Collectors.toSet());
    }

}
