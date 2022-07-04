package L04InterfacesAndAbstraction.P04FoodShortage_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            if (inputLine.length == 4) {
                citizens.add(new Citizen(inputLine[0], Integer.parseInt(inputLine[1]), inputLine[2], inputLine[3]));
                continue;
            }
            rebels.add(new Rebel(inputLine[0], Integer.parseInt(inputLine[1]), inputLine[2]));
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String name = command;

            citizens.stream().filter(citizen -> citizen.getName().equals(name))
                    .findFirst().ifPresent(Citizen::buyFood);

            rebels.stream().filter(rebel -> rebel.getName().equals(name))
                    .findFirst().ifPresent(Rebel::buyFood);
            command = scanner.nextLine();
        }

        System.out.println(citizens.stream()
                .map(Citizen::getFood)
                .reduce(0, Integer::sum)
                + rebels.stream()
                .map(Rebel::getFood)
                .reduce(0, Integer::sum));
        scanner.close();
    }
}

