package Exam03For3Time;

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
        List<String> mirrorList = new LinkedList<>();
        int countMatches = 0;
        while (matcher.find()){
            countMatches++;
            String firstWord = matcher.group("firstWord");
            StringBuilder secondWord = new StringBuilder(matcher.group("secondWord")).reverse();
            if (firstWord.equals(secondWord.toString())){
                mirrorList.add(firstWord + " <=> " + secondWord.reverse());
            }
        }
        if (countMatches != 0) {
            System.out.printf("%d word pairs found!%n", countMatches);
        } else {
            System.out.println("No word pairs found!");
        }
        if (!mirrorList.isEmpty()) {
            System.out.printf("The mirror words are:%n");
            System.out.println(String.join(", ",mirrorList));
        } else {
            System.out.println("No mirror words!");
        }

    }
}
