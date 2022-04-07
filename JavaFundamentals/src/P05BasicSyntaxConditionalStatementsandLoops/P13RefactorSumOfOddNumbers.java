package P05BasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P13RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 1; i <= 2 * n; i+=2) {
            System.out.printf("%d%n", i);
            sum += i;
        }
        System.out.printf("Sum: %d", sum);

    }
}
