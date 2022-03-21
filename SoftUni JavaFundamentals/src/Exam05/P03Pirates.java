package Exam05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> citiesPopulation = new LinkedHashMap<>();
        Map<String, Integer> citiesGold = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] inputArr = input.split("\\|\\|");
            if (!citiesPopulation.containsKey(inputArr[0])) {
                citiesPopulation.put(inputArr[0], Integer.parseInt(inputArr[1]));
                citiesGold.put(inputArr[0], Integer.parseInt(inputArr[2]));
            } else {
                int currentPopulation = citiesPopulation.get(inputArr[0]);
                int currentGold = citiesGold.get(inputArr[0]);
                citiesPopulation.put(inputArr[0], Integer.parseInt(inputArr[1]) + currentPopulation);
                citiesGold.put(inputArr[0], Integer.parseInt(inputArr[2]) + currentGold);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArr = command.split("=>");
            switch (commandArr[0]){
                case "Plunder":
                    String townToPlunder = commandArr[1];
                    int peopleKilled = Integer.parseInt(commandArr[2]);
                    int goldStolen = Integer.parseInt(commandArr[3]);
                    int currentCitiPop = citiesPopulation.get(townToPlunder);
                    int currentCitiGold = citiesGold.get(townToPlunder);
                    citiesPopulation.put(townToPlunder, currentCitiPop - peopleKilled);
                    citiesGold.put(townToPlunder,currentCitiGold - goldStolen);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", townToPlunder, goldStolen, peopleKilled);
                    int currentCitiPopCheck = citiesPopulation.get(townToPlunder);
                    int currentCitiGoldCheck = citiesGold.get(townToPlunder);
                    if (currentCitiGoldCheck <= 0 || currentCitiPopCheck <= 0) {
                        citiesPopulation.remove(townToPlunder);
                        citiesGold.remove(townToPlunder);
                        System.out.printf("%s has been wiped off the map!%n", townToPlunder);
                    }
                    break;
                case "Prosper":
                    String townToProsper = commandArr[1];
                    int goldToProsper = Integer.parseInt(commandArr[2]);
                    int currentGold = citiesGold.get(townToProsper);
                    if (goldToProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        command = scanner.nextLine();
                        continue;
                    }  else {
                        citiesGold.put(townToProsper, currentGold + goldToProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %s gold.%n",goldToProsper, townToProsper, citiesGold.get(townToProsper));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesPopulation.size());
        citiesPopulation.entrySet().stream().forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue(),
                citiesGold.get(entry.getKey())));
    }
}
