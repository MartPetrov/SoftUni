package FinalExam030422;

import java.util.Scanner;

public class P01StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] commandArr = scanner.nextLine().split(" ");

        while (!commandArr[0].equals("End")) {
            switch (commandArr[0]) {
                case "Translate":
                    String toReplace = commandArr[1];
                    String replacement = commandArr[2];
                    input = translate (input,toReplace,replacement);
                    System.out.println(input);
                    break;
                case "Includes":
                    String subStringCheck = commandArr[1];
                    includes (input,subStringCheck);
                    break;
                case "Start":
                    String startSub = commandArr[1];
                    start (input,startSub);
                    break;
                case "Lowercase":
                   input = lowercase (input);
                    break;
                case "FindIndex":
                    String lastChar = commandArr[1];
                    findIndex (input,lastChar);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int count = Integer.parseInt(commandArr[2]);
                    input = remove(input,startIndex,count);
                    break;

            }
            commandArr = scanner.nextLine().split(" ");
        }
    }

    private static String remove(String input, int startIndex, int count) {
        StringBuilder sbToRemove = new StringBuilder(input);
        sbToRemove.delete(startIndex,startIndex+count);
        input = sbToRemove.toString();
        System.out.println(input);
        return input;
    }

    private static void findIndex(String input, String lastChar) {
        StringBuilder sb = new StringBuilder(input);
        int lastIndex = sb.lastIndexOf(lastChar);
        System.out.println(lastIndex);
    }

    private static String lowercase(String input) {
        input = input.toLowerCase();
        System.out.println(input);
        return input;
    }

    private static void start(String input, String startSub) {
        if (input.startsWith(startSub)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static void includes(String input, String subStringCheck) {
        if (input.contains(subStringCheck)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static String translate(String input, String toReplace, String replacement) {
        input = input.replace(toReplace,replacement);
        return input;
    }
}
