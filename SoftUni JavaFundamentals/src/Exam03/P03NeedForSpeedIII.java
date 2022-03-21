package Exam03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carMileMap = new LinkedHashMap<>();
        Map<String, Integer> carFuelMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            carMileMap.put(input[0], Integer.parseInt(input[1]));
            carFuelMap.put(input[0], Integer.parseInt(input[2]));
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandArr = command.split(" : ");
            switch (commandArr[0]) {
                case "Drive":
                    String carName = commandArr[1];
                    int distanceForDriven = Integer.parseInt(commandArr[2]);
                    int fuelNeeded = Integer.parseInt(commandArr[3]);

                    int currentDistance = carMileMap.get(carName);
                    int currentFuel = carFuelMap.get(carName);
                    if (currentFuel >= fuelNeeded) {
                        carFuelMap.put(carName, currentFuel - fuelNeeded);
                        carMileMap.put(carName, currentDistance + distanceForDriven);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distanceForDriven, fuelNeeded);
                        if (carMileMap.get(carName) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            carFuelMap.remove(carName);
                            carMileMap.remove(carName);
                        }
                    } else {
                        System.out.printf("Not enough fuel to make that ride%n");
                    }
                    break;
                case "Refuel":
                    String carToRefuel = commandArr[1];
                    int fuelToRefuel = Integer.parseInt(commandArr[2]);
                    int currentFuelInCars = carFuelMap.get(carToRefuel);
                    carFuelMap.put(carToRefuel, currentFuelInCars + fuelToRefuel);
                    if (carFuelMap.get(carToRefuel) > 75) {
                        carFuelMap.put(carToRefuel, 75);
                        System.out.printf("%s refueled with %d liters%n", carToRefuel, 75 - currentFuelInCars);
                    } else {
                        System.out.printf("%s refueled with %d liters%n", carToRefuel, carFuelMap.get(carToRefuel) - currentFuelInCars);
                    }
                    break;
                case "Revert":
                    String carToRevert = commandArr[1];
                    int mileToRevert = Integer.parseInt(commandArr[2]);
                    int currentMile = carMileMap.get(carToRevert);
                    carMileMap.put(carToRevert, currentMile - mileToRevert);
                    if (carMileMap.get(carToRevert) <= 10000) {
                        carMileMap.put(carToRevert, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carToRevert, mileToRevert);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        carMileMap.entrySet().stream().forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(),
                entry.getValue(), carFuelMap.get(entry.getKey())));
    }
}
