package P05BasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        boolean isEven = false;

        while (!isEven) {
            if (num % 2 == 0) {
                isEven = true;
                System.out.println("The number is: " + Math.abs(num));
                break;
            } else {
                System.out.printf("Please write an even number.%n");
                num = Integer.parseInt(scanner.nextLine());
            }
        }

    }
}
