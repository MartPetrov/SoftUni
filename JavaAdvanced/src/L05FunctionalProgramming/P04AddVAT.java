package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = price -> price * 1.2;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(Double::parseDouble).map(addVat).forEach(printer);
    }
}
