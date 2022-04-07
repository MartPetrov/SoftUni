package P05BasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P11MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        if (firstNum <= 10 && secondNum <= 10) {
            for (int i = secondNum; i <= 10 ; i++) {
                sum = firstNum * secondNum;
                System.out.printf("%d X %d = %d%n", firstNum, secondNum, sum);
                secondNum++;
            }
        } else {
            sum = firstNum * secondNum;
            System.out.printf("%d X %d = %d", firstNum, secondNum, sum);
        }

    }
}
