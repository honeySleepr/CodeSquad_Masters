package cs06;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

//불변성 (Immutable) 값이나 변수를 적극 활용할 수 있다.
// 함수가 참조 투명성을 지키고, 부작용을 줄일 수 있도록 구현할 수 있다.
// 순수함수 (Pure Function) 로 구현할 수 있다.
// 1부터 100까지 숫자를 각 함수에 넣고 동작 결과가 동일해야 한다.

public class ClassifierAlpha extends Alpha {

    public Function<Set<Integer>, Integer> sum = f -> f.stream().reduce(0, (x, y) -> x + y);
    // 기본값 0을 안주면 x,y null일 수 있어서 옵셔널을 반환한다.

    /* sum, factors 같은 함수도 인자로 넣어줘야 완벽한 순수함수가 될 거라고 생각한다.
    * 하지만 그렇게 하니 가독성이 너무 떨어져서 number만 인자로 넣어주는 것으로 하였다.*/

    public Predicate<Integer> isPerfect = (number) -> sum.apply(factors2.apply(number)) - number == number;

    public Predicate<Integer> isAbundant = (number) -> sum.apply(factors2.apply(number)) - number > number;

    public Predicate<Integer> isDeficient = (number) -> sum.apply(factors2.apply(number)) - number < number;

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {

            int random = new Random().nextInt(100) + 1;
            ClassifierAlpha alpha = new ClassifierAlpha();

            System.out.println(random + "의 약수 : " + alpha.factors2.apply(random)
                + " [약수들의 합 = " + alpha.sum.apply(alpha.factors2.apply(random))
                + "]  [2N = " + random * 2 + "]");

            System.out.println(random + "의 약수 : " + alpha.factors2.apply(random));
            System.out.println("isPerfect= " + alpha.isPerfect.test(random));        // N의 약수들의 합이 2N과 **같은지** 판별
            System.out.println("isAbundant= " + alpha.isAbundant.test(random));      // N의 약수들의 합이 2N보다 **큰지** 판별
            System.out.println("isDeficient= " + alpha.isDeficient.test(random));    // N의 약수들의 합이 2N보다 **작은지** 판별
        }

    }
}