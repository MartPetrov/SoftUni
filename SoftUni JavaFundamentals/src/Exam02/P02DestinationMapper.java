package Exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<city>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        List<String> destinationList = new ArrayList<>();
        while (matcher.find()) {
            destinationList.add(matcher.group("city"));
        }
        int travelPoint = 0;
        for (int i = 0; i < destinationList.size(); i++) {
            String currentCity = destinationList.get(i);
            int currentCityPoint = currentCity.length();
            travelPoint += currentCityPoint;
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationList));
        System.out.printf("Travel Points: %d", travelPoint);
    }
}
