package Exam05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern patternEmoji = Pattern.compile("(?<product>[:]{2}[A-Z][a-z]{2,}[:]{2}|[*]{2}[A-Z][a-z]{2,}[*]{2})");
        Matcher matcherEmoji = patternEmoji.matcher(text);

        Pattern forDigit = Pattern.compile("\\d");
        Matcher matcherForDigits = forDigit.matcher(text);
        int countEmoji = 0;
        BigInteger thresholdSum = BigInteger.valueOf(1);
        List<String> coolEmoji = new ArrayList<>();
        while (matcherForDigits.find()) {
            thresholdSum = thresholdSum.multiply(BigInteger.valueOf(Long.parseLong(matcherForDigits.group())));
        }
        System.out.printf("Cool threshold: %d%n", thresholdSum);
        while (matcherEmoji.find()) {
            String currentEmoji = matcherEmoji.group().substring(2, matcherEmoji.group().length() - 2);
            if (thresholdSum.compareTo(BigInteger.valueOf(currentEmoji.chars().sum()))< 0) {
                coolEmoji.add(matcherEmoji.group());
            }
            countEmoji++;
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmoji);
        coolEmoji.forEach(System.out::println);
    }
}
