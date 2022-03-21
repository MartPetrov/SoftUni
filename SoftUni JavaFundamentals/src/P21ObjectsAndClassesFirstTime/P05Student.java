package P21ObjectsAndClassesFirstTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Student {

    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getTown() {
            return this.town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] dataArr = input.split(" ");

            String firstName = dataArr[0];
            String lastName = dataArr[1];
            String age = dataArr[2];
            String town = dataArr[3];

            Student student = new Student(firstName, lastName, age, town);

            studentsList.add(student);

            input = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();

        for (Student s : studentsList) {
            if (s.getTown().equals(searchTown)) {
                System.out.printf("%s %s is %s years old%n",
                        s.getFirstName(),
                        s.getLastName(),
                        s.getAge());
            }
        }
    }
}
