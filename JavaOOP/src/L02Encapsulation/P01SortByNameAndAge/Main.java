package L02Encapsulation.P01SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
        people.sort(Comparator.comparing(Person::getFirstName).thenComparingInt(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}
