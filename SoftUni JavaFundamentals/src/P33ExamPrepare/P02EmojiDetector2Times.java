package P33ExamPrepare;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector2Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern patternForEmoji = Pattern.compile("([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2})");
        Pattern patternForSum = Pattern.compile("\\d");

        Matcher matcherForText = patternForEmoji.matcher(text);
        Matcher threshold = patternForSum.matcher(text);
        BigInteger thresholdSum = BigInteger.valueOf(1);
        while (threshold.find()) {
            thresholdSum = thresholdSum.multiply(BigInteger.valueOf(Long.parseLong(threshold.group())));
        }
        System.out.println("Cool threshold: " + thresholdSum);

        int emojiCount=0;
        List<String> coolEmoji = new ArrayList<>();
        while (matcherForText.find()) {
           String emoji = matcherForText.group().substring(2,matcherForText.group().length()-2);
            if(thresholdSum.compareTo(BigInteger.valueOf(emoji.chars().sum())) < 0) coolEmoji.add(matcherForText.group());
                emojiCount++;

        }
        System.out.println(emojiCount + " emojis found in the text. The cool ones are:");
        coolEmoji.forEach(System.out::println);
    }
}
