package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(input);
        List<String> destination = new ArrayList<>();
        while (matcher.find()){
            destination.add(matcher.group("destination"));
        }
        System.out.printf("Destinations: %s%n",String.join(", ", destination));
        System.out.printf("Travel Points: %d", point(destination));
    }

    private static int point(List<String> destination) {
        int pointAll = 0;
        for (int i = 0; i < destination.size() ; i++) {
            int currentPoint = destination.get(i).length();
            pointAll +=currentPoint;
        }
        return pointAll;
    }
}
