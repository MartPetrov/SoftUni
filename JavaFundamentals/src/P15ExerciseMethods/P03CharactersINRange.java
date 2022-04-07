package P15ExerciseMethods;

import java.util.Scanner;

public class P03CharactersINRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //метод който отпечатва ред с всички символи от по - малкия(< аски код)
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printSequenceOfChars (symbol1, symbol2);
    }

    private static void printSequenceOfChars(char symbol1, char symbol2) {
        // Проверка от кой символ да започнем
        if (symbol1 < symbol2) {
            for (int i = symbol1 + 1; i < symbol2 ; i++) {
                System.out.print((char)i +" ");
            }
        } else {
            for (int i = symbol2 + 1; i < symbol1; i++) {
                System.out.print((char)i +" ");
            }
        }
    }
}
