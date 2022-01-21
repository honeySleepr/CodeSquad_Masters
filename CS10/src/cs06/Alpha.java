package cs06;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Alpha {

    private BiPredicate<Integer, Integer> isFactor = (i, number) -> number % i == 0;

    protected Function<Integer, Set<Integer>> factors2 = (number) ->
        IntStream.rangeClosed(1, (int) Math.sqrt(number))
            .filter(i -> isFactor.test(i, number))
            .mapToObj(i -> List.of(i, number / i))
            .flatMap(List::stream)
            .collect(Collectors.toSet());
}

/*
[map] : Stream<List<Integer>> -> Stream<Stream<Integer>>
[flatMap] : Stream<List<Integer>> -> Stream<Integer>
*/
