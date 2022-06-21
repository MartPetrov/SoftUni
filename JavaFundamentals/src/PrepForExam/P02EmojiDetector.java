package com.PrepForExam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern patternForEmoji = Pattern.compile("(?<product>[:]{2}[A-Z][a-z]{2,}[:]{2}|[*]{2}[A-Z][a-z]{2,}[*]{2})");
        Matcher matcherForEmoji = patternForEmoji.matcher(text);

        Pattern patternForDigit = Pattern.compile("\\d");
        Matcher matcherForDigit = patternForDigit.matcher(text);

        BigInteger coolThreshold = BigInteger.valueOf(1);

        while (matcherForDigit.find()) {
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(Long.parseLong(matcherForDigit.group())));
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        List<String> listOfEmoji = new ArrayList<>();
        int countEmojiAll = 0;
        while (matcherForEmoji.find()) {
            String currentEmoji = matcherForEmoji.group();
            countEmojiAll++;
            String emojiToCheck = currentEmoji.substring(2, currentEmoji.length() - 2);
            BigInteger emojiCurrentSum = BigInteger.valueOf(0);
            for (int i = 0; i < emojiToCheck.length(); i++) {
                BigInteger current = BigInteger.valueOf(emojiToCheck.charAt(i));
                emojiCurrentSum = emojiCurrentSum.add(current);
            }
            if (emojiCurrentSum.compareTo(coolThreshold) >= 0) {
                listOfEmoji.add(matcherForEmoji.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmojiAll);
        for (String currentEmojiPrint : listOfEmoji) {
            System.out.println(currentEmojiPrint);
        }
    }
}
