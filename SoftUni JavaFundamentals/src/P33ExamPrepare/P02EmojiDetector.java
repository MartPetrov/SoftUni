package P33ExamPrepare;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern patternForWord = Pattern.compile("([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2})");
        Pattern patternForDigit = Pattern.compile("\\d");
        Matcher emojiMatcher = patternForWord.matcher(input);
        Matcher threshold = patternForDigit.matcher(input);
        BigInteger thresholdSum = BigInteger.valueOf(1);
        while (threshold.find()) {
            thresholdSum = thresholdSum.multiply(BigInteger.valueOf(Long.parseLong(threshold.group())));
        }
        System.out.println("Cool threshold: " + thresholdSum);
        int emojiCount=0;
        List<String> coolEmoji = new ArrayList<>();
        while (emojiMatcher.find()) {
            String emoji = emojiMatcher.group().substring(2, emojiMatcher.group().length()-2);
            if(thresholdSum.compareTo(BigInteger.valueOf(emoji.chars().sum())) < 0) coolEmoji.add(emojiMatcher.group());
            emojiCount++;
        }

        System.out.println(emojiCount + " emojis found in the text. The cool ones are:");
        coolEmoji.forEach(System.out::println);

    }
}
