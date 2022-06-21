package com.PrepForExam;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());
        String[] commandArr = scanner.nextLine().split(":");

        while (!commandArr[0].equals("Travel")) {
            switch (commandArr[0]) {
                case "Add Stop":
                    int indexToAdd = Integer.parseInt(commandArr[1]);
                    String stringToAdd = commandArr[2];
                    if (isValidIndex(stops,indexToAdd)) {
                        addStop (stops,indexToAdd,stringToAdd);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    if (isValidIndex(stops,startIndex) && isValidIndex(stops,endIndex)) {
                        removeStop (stops,startIndex,endIndex);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = commandArr[1];
                    String newString = commandArr[2];
                    stops = switchText (stops,oldString,newString);
                    System.out.println(stops);
                    break;
            }
            commandArr = scanner.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }

    private static StringBuilder switchText(StringBuilder stops, String oldString, String newString) {
        if (stops.toString().contains(oldString)) {
            stops = new StringBuilder(stops.toString().replace(oldString, newString));
        }
        return stops;
    }

    private static boolean isValidIndex(StringBuilder stops, int indexToAdd) {
        return indexToAdd >=0 && indexToAdd <stops.length();
    }

    private static void removeStop(StringBuilder stops, int startIndex, int endIndex) {
        stops.delete(startIndex,endIndex+1);
    }

    private static void addStop(StringBuilder stops, int indexToAdd, String stringToAdd) {
        stops.insert(indexToAdd,stringToAdd);
    }
}
