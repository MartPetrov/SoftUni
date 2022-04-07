package P27TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = scanner.nextLine().split(" ");
        List<String> wordsList = new ArrayList<>();
        for (String s : wordsArr) {
            wordsList.add(repeatString(s, s.length()));
        }
        System.out.println(String.join("", wordsList));
    }

    public static String repeatString(String word, int count) {
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(word);
        }

        return sb.toString();
    }
}
