package com.PrepForExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> populationMap = new LinkedHashMap<>();
        Map<String, Integer> goldMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] inputArr = input.split("\\|\\|");
            if (populationMap.containsKey(inputArr[0])) {
                int currentPop = populationMap.get(inputArr[0]);
                int currentGold = goldMap.get(inputArr[0]);
                populationMap.put(inputArr[0],currentPop + Integer.parseInt(inputArr[1]));
                goldMap.put(inputArr[0], currentGold + Integer.parseInt(inputArr[2]));
            } else {
                populationMap.put(inputArr[0], Integer.parseInt(inputArr[1]));
                goldMap.put(inputArr[0], Integer.parseInt(inputArr[2]));
            }


            input = scanner.nextLine();
        }

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("End")) {
            String[] command = inputCommand.split("=>");
            if (command[0].equals("Plunder")) {
                String currentCity = command[1];
                int killedPeople = Integer.parseInt(command[2]);
                int stolenGold = Integer.parseInt(command[3]);
                int currentPopulation = populationMap.get(currentCity);
                int currentGold = goldMap.get(currentCity);
                populationMap.put(currentCity,currentPopulation - killedPeople);
                goldMap.put(currentCity,currentGold - stolenGold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", currentCity,stolenGold,killedPeople);

                if (populationMap.get(currentCity)<=0 || goldMap.get(currentCity) <= 0) {
                    populationMap.remove(currentCity);
                    goldMap.remove(currentCity);
                    System.out.printf("%s has been wiped off the map!%n", currentCity);
                }

            } else if (command[0].equals("Prosper")) {
                String currentCity = command[1];
                int goldToProsper = Integer.parseInt(command[2]);
                if (goldToProsper < 0) {
                    System.out.printf("Gold added cannot be a negative number!%n");
                    inputCommand = scanner.nextLine();
                    continue;
                }
                int currentGold = goldMap.get(currentCity);
                goldMap.put(currentCity,currentGold + goldToProsper);
                int goldAfterAdd = goldMap.get(currentCity);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToProsper,currentCity,goldAfterAdd);
            }

            inputCommand = scanner.nextLine();
        }
        if (populationMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", populationMap.size());
            populationMap.entrySet().forEach
                    (e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",e.getKey(),e.getValue(),goldMap.get(e.getKey())));
        }
    }
}
