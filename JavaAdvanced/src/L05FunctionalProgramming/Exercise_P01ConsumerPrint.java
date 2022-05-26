package L05FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Exercise_P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        Consumer<ArrayList<String>> printName = array -> {
            for (Object name: names) {
                System.out.println(name);
            }
        };

        printName.accept(names);
    }
}
