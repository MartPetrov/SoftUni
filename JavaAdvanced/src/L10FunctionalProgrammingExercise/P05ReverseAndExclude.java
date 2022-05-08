package L10FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        //Predicate<Integer> checkDivision = number -> number % n == 0;
        //numbers.removeIf(checkDivision);

        Predicate<Integer> checkDivision = number -> number % n != 0;
        numbers = numbers.stream().filter(checkDivision).collect(Collectors.toList());
        numbers.forEach(number -> System.out.print(number + " "));
    }
}
