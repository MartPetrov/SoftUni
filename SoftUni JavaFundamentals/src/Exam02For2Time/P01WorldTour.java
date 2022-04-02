package Exam02For2Time;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("Travel")) {
            String[] commandArr = inputCommand.split(":");
            switch (commandArr[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commandArr[1]);
                    String stopToAdd = commandArr[2];
                    if (isValid(index,inputText)) {
                       inputText = add(index,stopToAdd,inputText);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    if (isValid(startIndex,inputText) && isValid(endIndex,inputText)){
                        inputText = removeStop (inputText,startIndex,endIndex);
                    }
                    break;
                case "Switch":
                    String oldString = commandArr[1];
                    String newString = commandArr[2];
                    inputText = switchText (inputText,oldString,newString);
                    break;
            }
            System.out.println(inputText);

            inputCommand = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", inputText);
    }

    private static String switchText(String inputText, String oldString, String newString) {
        if (inputText.contains(oldString)) {
            inputText = inputText.replace(oldString,newString);
        }
        return inputText;
    }

    private static String removeStop(String inputText, int startIndex, int endIndex) {
        StringBuilder sbToRemove = new StringBuilder(inputText);
        sbToRemove = sbToRemove.replace(startIndex,endIndex + 1,"");
        return inputText = sbToRemove.toString();
    }

    private static String add(int index, String stopToAdd, String inputText) {
        StringBuilder sb = new StringBuilder(inputText);
        sb = sb.insert(index,stopToAdd);
        return inputText = sb.toString();
    }

    private static boolean isValid(int index,String text) {
        if (index >= 0 && index < text.length()) {
            return  true;
        } else {
            return false;
        }
    }
}
