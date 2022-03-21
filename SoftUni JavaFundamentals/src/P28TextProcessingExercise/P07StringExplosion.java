package P28TextProcessingExercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);
        int strength = 0;
        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            if (currentSymbol == '>') {
                strength += Integer.parseInt("" + text.charAt(index + 1));
            } else if (currentSymbol != '>' && strength > 0) {
                text.deleteCharAt(index);
                strength--;
                index--;
            }
        }
        System.out.println(text);
    }
}
