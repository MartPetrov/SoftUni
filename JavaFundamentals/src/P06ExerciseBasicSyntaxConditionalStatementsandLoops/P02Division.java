package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String divisible = "";

        if (input % 10 == 0) {
            divisible = "10";
        } else if (input % 7 == 0) {
            divisible = "7";
        } else if (input % 6 == 0) {
            divisible = "6";
        } else if (input % 3 == 0) {
            divisible = "3";
        } else if (input % 2 == 0) {
            divisible = "2";
        } else {
            divisible = "Not divisible";
        }
        if (divisible.equals("Not divisible")){
        System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %s", divisible);
        }
    }
}
