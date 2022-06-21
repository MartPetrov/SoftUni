package L02Encapsulation.P03ValidationData;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> collectionPeople = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            collectionPeople.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }

        double bonus = Double.parseDouble(scanner.nextLine());
        for (Person person : collectionPeople) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }

    }
}
