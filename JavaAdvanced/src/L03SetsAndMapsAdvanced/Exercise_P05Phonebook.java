package L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phonebook = new LinkedHashMap<>();


        String data = scanner.nextLine();

        while (!data.equals("search")) {
            String[] dataArr = data.split("-");
            phonebook.put(dataArr[0],dataArr[1]);
            data = scanner.nextLine();
        }

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }
    }
}
