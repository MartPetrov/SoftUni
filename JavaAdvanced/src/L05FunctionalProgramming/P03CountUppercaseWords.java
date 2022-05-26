package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));
        List<String> upperCaseWords = Arrays.stream(scanner.nextLine().split(" "))
                .filter(upperCasePredicate)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords.size());

        Consumer<String> printer = System.out::println;
        upperCaseWords.forEach(printer);
    }
}
