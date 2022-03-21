package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// ((daysInMonth * capsulesCount) * pricePerCapsule)

        int n = Integer.parseInt(scanner.nextLine());

        double allprice = 0;

        for (int i = 1; i <= n ; i++) {
            double pricePerCaps = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double pricePerCount = (days * capsulesCount) * pricePerCaps;
            allprice += pricePerCount;
            System.out.printf("The price for the coffee is: $%.2f%n", pricePerCount);
        }
        System.out.printf("Total: $%.2f", allprice);
    }
}
