package L01WorkingWithAbstraction.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> mapOfStudent;

    public StudentSystem() {
        this.mapOfStudent = new HashMap<>();
    }

    public Map<String, Student> getMapOfStudent() {
        return this.mapOfStudent;
    }

    public void executeCommand(String[] commandParts) {
        if (commandParts[0].equals("Create")) {
            createStudent(commandParts);
        } else if (commandParts[0].equals("Show")) {
            String name = commandParts[1];
            if (mapOfStudent.containsKey(name)) {
                Student student = mapOfStudent.get(name);
                String view = getStudentType(student);
                System.out.println(view);
            }
        }
    }

    private void createStudent(String[] commandParts) {
        String name = commandParts[1];
        int age = Integer.parseInt(commandParts[2]);
        double grade = Double.parseDouble(commandParts[3]);
        Student student = new Student(name, age, grade);
        mapOfStudent.putIfAbsent(name, student);
    }

    private String getStudentType(Student student) {

        StringBuilder output = new StringBuilder(student.toString());
        if (student.getGrade() >= 5.00) {
            output.append(" Excellent student.");
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            output.append(" Average student.");
        } else {
            output.append(" Very nice person.");
        }
        return output.toString();
    }
}
