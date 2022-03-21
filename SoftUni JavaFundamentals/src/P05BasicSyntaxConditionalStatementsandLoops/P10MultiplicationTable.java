package P05BasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10 ; i++) {
            int sum = i * num;
            System.out.printf("%d X %d = %d%n", num, i , sum);
        }


    }
}
