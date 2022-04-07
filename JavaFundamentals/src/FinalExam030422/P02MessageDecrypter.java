package FinalExam030422;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numMessage = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numMessage; i++) {

            String currentMessage = scanner.nextLine();
            Pattern pattern = Pattern.compile("^([$%])(?<type>[A-Z][a-z]{2,})\\1: (?<currentChar>\\[[0-9]+\\]\\|\\[[0-9]+\\]\\|\\[[0-9]+\\]\\|)$");
            Matcher matcher = pattern.matcher(currentMessage);
            boolean isFound = false;
            String currentToPrint = "";
            String typeToPrint = "";
            while (matcher.find()) {
                isFound = true;
                StringBuilder sb = new StringBuilder();
                String type = matcher.group("type");
                String currentString = matcher.group("currentChar");
                Pattern patternForCurrent = Pattern.compile("[0-9]+");
                Matcher matcherForCurrentChar = patternForCurrent.matcher(currentString);
                while (matcherForCurrentChar.find()) {
                    int currentChar = Integer.parseInt(matcherForCurrentChar.group());
                    sb.append((char) currentChar);
                }
                typeToPrint = type;
                currentToPrint = sb.toString();
            }
            if (isFound) {
                System.out.printf("%s: %s%n", typeToPrint, currentToPrint);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
