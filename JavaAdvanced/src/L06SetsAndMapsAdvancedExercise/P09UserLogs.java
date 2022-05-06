package L06SetsAndMapsAdvancedExercise;

import java.util.*;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        while (!input.equals("end")) {
            String[] inputParts = input.split("\\s+");
            String ip = inputParts[0].split("=")[1];
//            String message = inputParts[1].split("=")[1];
            String username = inputParts[2].split("=")[1];

            if (!data.containsKey(username)) {
                data.put(username, new LinkedHashMap<String, Integer>() {{
                    put(ip, 1);
                }});
            } else {
                Map<String, Integer> currentIps = data.get(username);
                if (currentIps.containsKey(ip)) {
                    int currentTimes = currentIps.get(ip);
                    currentIps.put(ip, currentTimes + 1);
                } else {
                    currentIps.put(ip, 1);
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user: data.entrySet()) {
            List<String> ipRow = new ArrayList<>();
            System.out.printf("%s: %n", user.getKey());
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }

            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0)
            {
                System.out.println(".");
            }
        }
    }
}
