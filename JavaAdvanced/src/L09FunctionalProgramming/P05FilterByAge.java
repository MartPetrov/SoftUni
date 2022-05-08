package L09FunctionalProgramming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> peopleMap = new LinkedHashMap<>();

        for (int i = 0; i < numPeople; i++) {
            String[] personData = scanner.nextLine().split(", ");
            peopleMap.put(personData[0],Integer.parseInt(personData[1]));
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;
        if (condition.equals("younger")) {
             filterPredicate = (personAge,age) -> personAge <= age;
        } else {
            filterPredicate = (personAge,age) -> personAge >= age;
        }

        Consumer<Map.Entry<String,Integer>> printConsumer;
        if (printFormat.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else if (printFormat.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else {
            printConsumer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        peopleMap.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(),ageLimit))
                .forEach(printConsumer);
    }
}
