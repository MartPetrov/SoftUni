package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ages = Integer.parseInt(scanner.nextLine());

        if (0 <= ages && ages <= 2) {
            System.out.println("baby");
        } else if (3 <= ages && ages <= 13) {
            System.out.println("child");
        }else if (14 <= ages && ages <= 19) {
            System.out.println("teenager");
        }else if (20 <= ages && ages <= 65) {
            System.out.println("adult");
        }else if (ages >= 66) {
            System.out.println("elder");
        }
    }
}
