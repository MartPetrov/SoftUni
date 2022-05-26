package L05FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));

        evenNumbers = evenNumbers.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));
    }
}
