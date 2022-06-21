package com.PrepForExam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> destinationList = new LinkedList<>();
        int travelPoint =0;
        while (matcher.find()) {
            destinationList.add(matcher.group("destination"));
            travelPoint += matcher.group("destination").length();
        }
        System.out.println("Destinations: " + String.join(", ", destinationList));
        System.out.println("Travel Points: " + travelPoint);
    }
}
