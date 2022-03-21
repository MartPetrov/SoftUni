package P33ExamPrepare;

import java.util.List;
import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Add Stop":
                    int index = Integer.parseInt(commandParts[1]);
                    String stopName = commandParts[2];
                    if (isValidIndex(index, stops)) {

                        String firstHalf = stops.substring(0, index);
                        String secondHalf = stops.substring(index);
                        stops = firstHalf + stopName + secondHalf;
                    }

                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (isValidIndex(startIndex, stops) && isValidIndex(endIndex, stops)) {
                        String firstHalf = stops.substring(0, startIndex);
                        String secondHalf = stops.substring(endIndex + 1);
                        stops = firstHalf + secondHalf;

                    }

                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString,newString);
                    }
                    break;

            }
            System.out.println(stops);
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    public static boolean isValidIndex(int index, String stops) {
        return index >= 0 && index < stops.length();
    }
}
