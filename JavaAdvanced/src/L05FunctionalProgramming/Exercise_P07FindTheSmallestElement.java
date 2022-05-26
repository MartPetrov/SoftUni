package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printIndexOfMinElement =
                list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        printIndexOfMinElement.accept(numbers);

//        Function<List<Integer>,Integer> getIndexSmallestElement =
//                list -> list.lastIndexOf(Collections.min(list));
//
//        System.out.println(getIndexSmallestElement.apply(numbers));
    }
}
