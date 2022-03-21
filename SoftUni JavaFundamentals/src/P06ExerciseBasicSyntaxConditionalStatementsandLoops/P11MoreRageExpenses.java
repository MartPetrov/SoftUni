package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P11MoreRageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());
        int count = 0;
        double sum = 0;

        for (int i = 1; i <= lostGames ; i++) {
            if (i % 2 ==0) {
                sum += priceHeadset;
            }
            if (i % 3 ==0) {
                sum += priceMouse;
            }
            if (i % 6 ==0) {
                sum += priceKeyboard;
                count++;
                if (count % 2 == 0){
                    sum += priceDisplay;
                }
            }

        }
        System.out.printf("Rage expenses: %.2f lv.", sum);

    }
}
