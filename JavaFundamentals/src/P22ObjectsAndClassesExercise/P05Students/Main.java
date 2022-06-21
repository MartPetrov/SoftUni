package P05Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudent =  Integer.parseInt(scanner.nextLine());
        List<Student> listOfStudents = new ArrayList<>();

        for (int i = 1; i <=countStudent ; i++) {
            String studentInfo = scanner.nextLine();

            String firstName = studentInfo.split(" ")[0];
            String secondName = studentInfo.split(" ")[1];
            double grade  = Double.parseDouble(studentInfo.split(" ")[2]);

            Student student = new Student(firstName,secondName,grade);
            listOfStudents.add(student);

        }

        listOfStudents.sort(Comparator.comparing(Student::getGrade).reversed());


        for (Student student: listOfStudents) {
            System.out.println(student);
        }
    }
}
