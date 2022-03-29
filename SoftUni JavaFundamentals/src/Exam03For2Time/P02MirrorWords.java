package Exam03For2Time;

import java.util.ArrayList;
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
        List<String> listOfMirrorWords = new ArrayList<>();
        int countMatch = 0;
        while (matcher.find()){
            countMatch++;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            StringBuilder secondWordsb = new StringBuilder(secondWord);
            String secondWordToCheck = secondWordsb.reverse().toString();
            if (firstWord.equals(secondWordToCheck)) {
                StringBuilder toAdd = new StringBuilder();
                toAdd.append(firstWord).append(" <=> ").append(secondWord);
                listOfMirrorWords.add(toAdd.toString());
            }
        }
        if (countMatch != 0) {
            System.out.printf("%d word pairs found!%n", countMatch);
        } else {
            System.out.println("No word pairs found!");
        }

        if (!listOfMirrorWords.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", listOfMirrorWords));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
