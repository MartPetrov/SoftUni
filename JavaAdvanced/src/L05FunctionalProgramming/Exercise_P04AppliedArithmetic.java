package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        // add -> добавя 1 към всеки елемент на листа: приемаме списък и връщаме списък с мод. елементи
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        // multiply -> умножаваме всеки елемент по 2
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        // subtract -> изваждаме от всички по едно
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        // print -> принтира всички елементи от списъка на нов ред
        Consumer<List<Integer>> printNumber = list -> list.forEach(number -> System.out.print(number + " "));

        applyFunc(scanner, numbers, command, add, multiply, subtract, printNumber);
    }

    private static void applyFunc(Scanner scanner, List<Integer> numbers, String command, Function<List<Integer>, List<Integer>> add, Function<List<Integer>, List<Integer>> multiply, Function<List<Integer>, List<Integer>> subtract, Consumer<List<Integer>> printNumber) {
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case"subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printNumber.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
