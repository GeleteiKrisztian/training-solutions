package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Stream;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Optional<Integer> min() {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        Stream<Integer> numsStream = numbers.stream();
        return numsStream.min((i1 ,i2) -> i1.compareTo(i2));
    }

    public int sum() {
        Stream<Integer> numsStream = numbers.stream();
        //BinaryOperator<Integer> op = (a, b) -> a + b;
        return numsStream.reduce(0, (iden, num ) -> iden += num );
    }

    public boolean isAllPositive() {
        Stream<Integer> numsStream = numbers.stream();
        return numsStream.allMatch(i -> i > 0);
    }

    public List<Integer> getDistinctElements() {
        Stream<Integer> numsStream = numbers.stream();
        Set<Integer> nums = numsStream.collect(HashSet::new, Set::add, Set::addAll);
        return new ArrayList<>(nums);
    }

}
