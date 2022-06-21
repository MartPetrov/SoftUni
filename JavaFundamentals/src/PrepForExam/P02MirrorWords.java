package com.PrepForExam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> mirrorWords = new LinkedList<>();
        int countMatcher = 0;
        while (matcher.find()) {
            countMatcher++;
            String firstWord = matcher.group("firstWord");
            StringBuilder secondWord = new StringBuilder(matcher.group("secondWord")).reverse();
            if (firstWord.equals(secondWord.toString())) {
                mirrorWords.add(firstWord + " <=> " + secondWord.reverse());
            }
        }

        if (countMatcher == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", countMatcher);
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}
