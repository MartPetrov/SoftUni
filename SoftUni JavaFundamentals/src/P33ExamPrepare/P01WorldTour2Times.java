package P33ExamPrepare;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01WorldTour2Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            List<String> commandList = Arrays.asList(command.split(":"));
            switch (commandList.get(0)) {
                case "Add Stop":
                    int indexToAdd = Integer.parseInt(commandList.get(1));
                    String stopToAdd = commandList.get(2);
                    if (isValid(stops, indexToAdd)) {
                        stops.insert(indexToAdd,stopToAdd);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndexToRemove = Integer.parseInt(commandList.get(1));
                    int endIndexToRemove = Integer.parseInt(commandList.get(2));

                    if (isValid(stops,startIndexToRemove) && isValid(stops,endIndexToRemove)) {
                        stops.replace(startIndexToRemove, endIndexToRemove + 1, "");
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = commandList.get(1);
                    String newString = commandList.get(2);
                    if (stops.toString().contains(oldString)) {
                        int indexOfOld = stops.indexOf(oldString);
                        stops.replace(indexOfOld, indexOfOld + oldString.length(),newString);
                    }
                    System.out.println(stops);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    public static boolean isValid(StringBuilder text, int index) {
        if (index >= 0 && index < text.length()) {
            return true;
        }
        return false;
    }
}
