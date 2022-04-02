package Exam;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String[] commandArr = command.split(":");
            switch (commandArr[0]){
                case "Add Stop":
                    int indexToAdd = Integer.parseInt(commandArr[1]);
                   if (isValidIndex(stops,indexToAdd)) {
                       String stringToAdd = commandArr[2];
                      stops = addstop(stops, indexToAdd, stringToAdd);
                   }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    if (isValidIndex(stops,startIndex) && isValidIndex(stops,endIndex + 1)){
                       stops = removeStop(stops,startIndex,endIndex);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = commandArr[1];
                    String newString = commandArr[2];
                    stops = switchOldwithNew(stops,oldString,newString);
                    System.out.println(stops);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    private static String switchOldwithNew(String stops, String oldString, String newString) {
        if (stops.contains(oldString)) {
            stops = stops.replace(oldString,newString);
        }
        return stops;
    }


    private static boolean isValidIndex(String stops, int index) {
        return index >= 0 && index <=stops.length();
    }

    private static String removeStop(String stops, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder(stops);
        sb.replace(startIndex,endIndex + 1,"");
        stops = sb.toString();
        return stops;
    }


    private static String addstop(String stops, int indexToAdd, String stringToAdd) {
        StringBuilder sb = new StringBuilder(stops);
        sb.insert(indexToAdd,stringToAdd);
        stops = sb.toString();
        return stops;
    }
}
