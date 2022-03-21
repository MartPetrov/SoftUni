package Exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#]{1})(?<firstWord>[A-Za-z]{3,})(\\1){2}(?<secondWord>[A-Za-z]{3,})");
        Matcher matcher = pattern.matcher(text);
        List<String> firstWordList = new ArrayList<>();
        List<String> secondWordList = new ArrayList<>();
        while (matcher.find()){
            firstWordList.add(matcher.group("firstWord"));
            secondWordList.add(matcher.group("secondWord"));
        }
        if (firstWordList.isEmpty()) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", firstWordList.size());
        }

        List<String> pairWord = new ArrayList<>();
        for (int i = 0; i < firstWordList.size() ; i++) {
            StringBuilder sbReverse = new StringBuilder(secondWordList.get(i)).reverse();
            String toCheck = sbReverse.toString();
            if (firstWordList.get(i).equals(toCheck)){
                pairWord.add(firstWordList.get(i) + " <=> " + secondWordList.get(i));
            }
        }
        if (pairWord.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ",pairWord));
        }
    }
}
