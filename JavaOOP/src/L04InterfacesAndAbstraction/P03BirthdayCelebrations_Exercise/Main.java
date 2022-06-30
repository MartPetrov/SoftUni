package L04InterfacesAndAbstraction.P03BirthdayCelebrations_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String information = scanner.nextLine();

        List<Birthable> livingBeings = new ArrayList<>();

        while (!information.equals("End")) {
            String[] splittedInformation = information.split(" ");
            switch (splittedInformation[0]) {
                case "Citizen":
                    livingBeings.add(new Citizen(splittedInformation[1],
                            Integer.parseInt(splittedInformation[2]),
                            splittedInformation[3],
                            splittedInformation[4]));
                    break;
                case "Pet":
                    livingBeings.add(new Pet(splittedInformation[1],
                            splittedInformation[2]));
                    break;
                case "Robot":
                    Robot robot = new Robot(splittedInformation[1],splittedInformation[2]);
                    break;
            }

            information = scanner.nextLine();
        }
        String years = scanner.nextLine();
        boolean isFound = false;
        for (Birthable birthable: livingBeings) {
            if (birthable.getBirthDate().endsWith(years)){
            System.out.println(birthable.getBirthDate());
            isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("<no output>");
        }
    }
}

