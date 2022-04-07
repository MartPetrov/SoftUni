package P15ExerciseMethods;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printMiddleCharecters(text);
    }

    private static void printMiddleCharecters(String text) {
        if (text.length() % 2 == 1) {
            int indexOffMiddleCharecter = text.length() / 2;
            System.out.println(text.charAt(indexOffMiddleCharecter));
        } else {
            int indexOffMiddlefirst = text.length() / 2 - 1;
            int indexOffMiddleSecond = text.length() / 2;
            System.out.printf("%c%c", text.charAt(indexOffMiddlefirst), text.charAt(indexOffMiddleSecond));
        }
    }
}
