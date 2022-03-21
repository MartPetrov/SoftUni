package P33ExamPrepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<symbol>[@#])(?<firstWords>[A-Za-z]{3,})(\\1)(\\1)(?<secondWords>[A-Za-z]{3,})\\1");

        Matcher matcher = pattern.matcher(text);

        List<String> wordList = new ArrayList<>();

        int count = 0;
        while (matcher.find()) {
            String first = matcher.group("firstWords");
            String second = matcher.group("secondWords");
            StringBuilder forChek = new StringBuilder();
            forChek.append(first).reverse();
            count++;
            if (forChek.toString().equals(second)) {
                wordList.add(matcher.group("firstWords") + " <=> " + matcher.group("secondWords"));
            }
        }
        if (count == 0) {
            System.out.printf("No word pairs found!%n");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (!wordList.isEmpty()) {
            System.out.printf("The mirror words are:%n");
        } else {
            System.out.printf("No mirror words!%n");
        }

        System.out.println(String.join(", ", wordList));

    }
}
