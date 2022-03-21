package P25AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommand = Integer.parseInt(scanner.nextLine());
        Map<String, String> commandMap = new LinkedHashMap<>();

        for (int i = 1; i <= numCommand; i++) {
            String commandLine = scanner.nextLine();
            List<String> currentCommand = Arrays.stream(commandLine.split(" ")).collect(Collectors.toList());
            String command = currentCommand.get(0);

            if ("register".equals(command)) {
                String username = currentCommand.get(1);
                String licensePlateNumber = currentCommand.get(2);
                if (!commandMap.containsKey(username)) {
                    commandMap.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", commandMap.get(username));
                }
            } else if ("unregister".equals(command)) {
                String username = currentCommand.get(1);
                if (commandMap.containsKey(username)) {
                    commandMap.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }


        }

        for (Map.Entry<String, String> entry : commandMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%s => %s%n", key, value);

        }
    }
}
