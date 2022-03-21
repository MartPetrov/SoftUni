package P25AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<String, List<String>> CompanyNameMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            List<String> inputList = Arrays.stream(input.split(" -> ")).collect(Collectors.toList());
            String companyName = inputList.get(0);
            String id = inputList.get(1);
            List<String> idList = new ArrayList<>();

            if (!CompanyNameMap.containsKey(companyName)) {
                CompanyNameMap.put(companyName, idList);
                idList.add(id);

            } else {
                List<String> CurrentCourse = CompanyNameMap.get(companyName);
                if (!CurrentCourse.contains(id)) {
                    CurrentCourse.add(id);
                }

            }


            input = scanner.nextLine();
        }

        CompanyNameMap.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.println("-- " + entry.getValue().get(i));
                    }
                });
    }
}
