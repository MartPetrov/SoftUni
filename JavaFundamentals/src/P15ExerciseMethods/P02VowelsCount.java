package P15ExerciseMethods;

import java.util.Scanner;

public class P02VowelsCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        int count = getVowelsCount(text);
        System.out.println(count);

    }

    public static int getVowelsCount(String text) {
        // гласни букви  a, e, i, o, u,

        int count = 0;

        for (int index = 0; index <= text.length() - 1; index++) {
            char currentSymbol = text.charAt(index);

            if (currentSymbol == 'a' || currentSymbol == 'e' ||
                    currentSymbol == 'i' || currentSymbol == 'o' || currentSymbol == 'u') {
                count++;
            }
        }
        return count;
    }
}
