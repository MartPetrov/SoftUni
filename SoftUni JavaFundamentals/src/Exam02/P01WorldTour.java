package Exam02;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] commandArr = command.split(":");
            switch (commandArr[0]) {
                case "Add Stop":
                    int indexToAdd = Integer.parseInt(commandArr[1]);
                    String toAdd = commandArr[2];
                    if (isValidIndex(indexToAdd, stops)) {
                        String firstHalf = stops.substring(0,indexToAdd);
                        String secondHalf = stops.substring(indexToAdd);
                        stops = firstHalf + toAdd + secondHalf;
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);

                    StringBuilder sbToRemove = new StringBuilder(stops);
                    if (isValidIndex(startIndex, stops) && isValidIndex(endIndex, stops)) {
                       String firstHalf = sbToRemove.substring(0,startIndex);
                       String secondHalf = sbToRemove.substring(endIndex+1);
                        stops = firstHalf + secondHalf;
                    }
                    break;
                case "Switch":
                    String oldString = commandArr[1];
                    String newString = commandArr[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }

                    break;
            }
            System.out.println(stops);
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);

    }

    public static Boolean isValidIndex(int index, String text) {
        return index >= 0 && index < text.length();

    }
}
