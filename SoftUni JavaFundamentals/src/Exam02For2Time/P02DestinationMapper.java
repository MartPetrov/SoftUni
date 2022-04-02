package Exam02For2Time;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([\\/=])(?<destination>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        int travelPoint = 0;
        List<String> destination = new LinkedList<>();
        while (matcher.find()) {
            destination.add(matcher.group("destination"));
            travelPoint += matcher.group("destination").length();
        }
        System.out.printf("Destinations: %s%n",String.join(", ", destination));
        System.out.printf("Travel Points: %d", travelPoint);
    }
}
