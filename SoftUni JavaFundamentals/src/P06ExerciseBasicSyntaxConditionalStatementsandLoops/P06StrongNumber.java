package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String num = scanner.nextLine();
        int firstNum = Integer.parseInt(num);
        int numb = firstNum;
        int alldigitsFact = 0;

        for (int i = 0 ; i < num.length() ; i++) {
            int digit = numb % 10;
            numb /= 10;
            int fact = 1;
            for (int j = 1; j <= digit ; j++) {
                fact *= j;
            }
            alldigitsFact += fact;

        }
        if (firstNum == alldigitsFact) {
            System.out.printf("yes");
        } else {
            System.out.printf("no");
        }
    }
}
