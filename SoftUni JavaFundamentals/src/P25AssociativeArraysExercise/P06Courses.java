package P25AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<String, List<String>> CourseMap = new LinkedHashMap<>();
        Map<String, Integer> CourseCount = new LinkedHashMap<>();
        while (!input.equals("end")) {
            List<String> inputList = Arrays.stream(input.split(" : ")).collect(Collectors.toList());
            String courseName = inputList.get(0);
            String studentName = inputList.get(1);
            List<String> studentsNameList = new ArrayList<>();

            if (!CourseMap.containsKey(courseName)) {
                CourseMap.put(courseName, studentsNameList);
                CourseCount.put(courseName, 1);
                studentsNameList.add(studentName);

            } else {
                List<String> CurrentCourse = CourseMap.get(courseName);
                CurrentCourse.add(studentName);
                int currentCount = CourseCount.get(courseName);
                CourseCount.put(courseName, currentCount + 1);
            }


            input = scanner.nextLine();
        }

        CourseMap.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.println("-- " + entry.getValue().get(i));
                    }
                });
    }
}
