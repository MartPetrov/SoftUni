package P33ExamPrepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);

        List<String> destinations = new ArrayList<>();
        int sumOfLetters = 0;
        while (matcher.find()){
            destinations.add(matcher.group("destination"));
        }
        for (int i = 0; i < destinations.size(); i++) {
            String current = destinations.get(i);
            for (int j = 0; j < current.length(); j++) {
                sumOfLetters++;
            }
        }

        System.out.printf("Destinations: "+ String.join(", ", destinations));
        System.out.println();
        System.out.printf("Travel Points: %d", sumOfLetters);


    }
}
