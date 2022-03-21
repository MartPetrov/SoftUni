package P33ExamPrepare;

import java.util.Scanner;

public class P01ActivationKeys2Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actKey = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");
            switch (commandArr[0]) {
                case "Contains":
                    String substring = commandArr[1];
                    if (actKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", actKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = commandArr[1];
                    StringBuilder sb = new StringBuilder();
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    if (type.equals("Upper")) {
                        for (int i = startIndex; i < endIndex; i++) {
                            sb.append(actKey.charAt(i)).toString();
                        }
                        actKey = actKey.replace(sb,sb.toString().toUpperCase());
                    } else {
                        for (int i = startIndex; i < endIndex; i++) {
                            sb.append(actKey.charAt(i)).toString();
                        }
                        actKey = actKey.replace(sb,sb.toString().toLowerCase());
                    }
                    System.out.println(actKey);
                    break;
                case "Slice":
                    int startIndexToSlice = Integer.parseInt(commandArr[1]);
                    int endIndexToSlice = Integer.parseInt(commandArr[2]);
                    String substringToRemove = actKey.substring(startIndexToSlice,endIndexToSlice);
                    actKey = actKey.replace(substringToRemove,"");
                    System.out.println(actKey);

                    break;

            }

            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", actKey);
    }
}
