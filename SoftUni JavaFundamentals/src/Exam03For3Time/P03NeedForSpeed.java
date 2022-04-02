package Exam03For3Time;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

public class P03NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < numCars; i++) {
            String[] carsInfo = scanner.nextLine().split("\\|");
            String name = carsInfo[0];
            int mileage = Integer.parseInt(carsInfo[1]);
            int fuel = Integer.parseInt(carsInfo[2]);
            Car car = new Car(name, mileage, fuel);
            carsMap.put(name, car);
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Stop")) {
            String[] commandArr = commandLine.split(" : ");
            Car currentCar = carsMap.get(commandArr[1]);
            switch (commandArr[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commandArr[2]);
                    int fuelNeeded = Integer.parseInt(commandArr[3]);
                    drive(carsMap, currentCar, distance, fuelNeeded);
                    break;
                case "Refuel":
                    int fuelToRe = Integer.parseInt(commandArr[2]);
                    refuel(carsMap, currentCar, fuelToRe);
                    break;
                case "Revert":
                    int kilometersToRevert = Integer.parseInt(commandArr[2]);
                    revert(carsMap, currentCar, kilometersToRevert);
                    break;

            }
            commandLine = scanner.nextLine();
        }


        for (Car cars : carsMap.values()) {
            System.out.println(cars);
        }
    }

    private static void drive(Map<String, Car> carsMap, Car currentCar, int distance, int fuelNeeded) {
        int currentFuel = currentCar.getFuel();
        if (currentFuel >= fuelNeeded) {
            currentCar.setMileage(currentCar.getMileage() + distance);
            currentCar.setFuel(currentFuel - fuelNeeded);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar.getName(), distance, fuelNeeded);
            if (currentCar.getMileage() >= 100000) {
                System.out.printf("Time to sell the %s!%n", currentCar.getName());
                carsMap.remove(currentCar.getName());
            }
        } else {
            System.out.println("Not enough fuel to make that ride");
        }
    }

    private static void refuel(Map<String, Car> carsMap, Car currentCar, int fuelToRe) {
        int currentFuel = currentCar.getFuel();
        currentCar.setFuel(Math.min(currentFuel + fuelToRe, 75));
        System.out.printf("%s refueled with %d liters%n", currentCar.getName(), currentCar.getFuel() - currentFuel);
    }

    private static void revert(Map<String, Car> carsMap, Car currentCar, int kilometersToRevert) {
        int currentMiles = currentCar.getMileage();
        currentCar.setMileage(Math.max(currentMiles - kilometersToRevert, 10000));
        if (currentMiles - kilometersToRevert >= 10000) {
            System.out.printf("%s mileage decreased by %d kilometers%n", currentCar.getName(), currentMiles - currentCar.getMileage());
        }
    }

    public static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        @Override
        public String toString() {
            return String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", getName(), getMileage(), getFuel());
        }
    }
}
