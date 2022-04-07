package P05BasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P03PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double number = Double.parseDouble(scanner.nextLine());
        if (number > 2.99) {
            System.out.printf("Passed!");
        } else {
            System.out.printf("Failed!");
        }



    }
}
