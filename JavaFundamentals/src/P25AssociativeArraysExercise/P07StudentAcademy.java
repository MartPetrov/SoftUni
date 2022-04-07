package P25AssociativeArraysExercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();
        for (int i = 0; i < countStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);

        }
        // студенттите със средна оценка над или равна на  4.50
        Map<String, Double> studentAverageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry: studentsMap.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
//            double averageGrade = getAverageGrades (grades);
            double averageGrade = grades.stream().mapToDouble(x->x).average().getAsDouble();
            if (averageGrade >= 4.50) {
                studentAverageGrade.put(studentName, averageGrade);
            }
        }

        studentAverageGrade.entrySet().stream()
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));


    }

//    private static double getAverageGrades(List<Double> grades) {
//        double sumGrade = 0;
//        for (double grade : grades) {
//            sumGrade += grade;
//        }
//        return  sumGrade/ grades.size();
//    }
}
