package P25AssociativeArraysExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> charsCount = new LinkedHashMap<>();

        for (char symbol: text.toCharArray()) {
            if (symbol == ' '){
                continue;
            }
            if (!charsCount.containsKey(symbol)){
                charsCount.put(symbol,1);
            } else {
                int currentCount = charsCount.get(symbol);
                charsCount.put(symbol,currentCount + 1);
            }
        }

        charsCount.forEach((key, value) -> System.out.printf("%c -> %d%n", key, value));
    }
}
