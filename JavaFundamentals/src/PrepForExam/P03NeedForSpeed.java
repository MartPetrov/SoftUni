package com.PrepForExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < numCars; i++) {
            String[] carsInfo = scanner.nextLine().split("\\|");
            String carName = carsInfo[0];
            int mileage = Integer.parseInt(carsInfo[1]);
            int fuel = Integer.parseInt(carsInfo[2]);
            Car car = new Car(carName, mileage, fuel);
            carsMap.put(carName, car);
        }

        String[] commandArr = scanner.nextLine().split(" : ");
        while (!commandArr[0].equals("Stop")) {
            switch (commandArr[0]) {

                case "Drive":
                    String carDrive = commandArr[1];
                    Car currentCar = carsMap.get(carDrive);
                    int distance = Integer.parseInt(commandArr[2]);
                    int fuelNeeded = Integer.parseInt(commandArr[3]);
                    drive (carsMap,currentCar,distance,fuelNeeded);

                    break;
                case "Refuel":
                    String carRefuel = commandArr[1];
                    int fuelForRe = Integer.parseInt(commandArr[2]);
                    Car currentCarForRefuel = carsMap.get(carRefuel);
                    refuel (carsMap, currentCarForRefuel,fuelForRe);
                    break;
                case "Revert":

                    String carToRevert = commandArr[1];
                    int kilometers = Integer.parseInt(commandArr[2]);
                    Car currentCarForRevert = carsMap.get(carToRevert);
                    revert (carsMap,currentCarForRevert, kilometers);
                    break;

            }

            commandArr = scanner.nextLine().split(" : ");
        }
        for (Car car : carsMap.values()) {
            System.out.println(car);
        }
    }

    private static void revert(Map<String, Car> carsMap, Car currentCarForRevert, int kilometers) {
        int currentKm = currentCarForRevert.getMileage();
        currentCarForRevert.setMileage(Math.max(currentKm - kilometers, 10000));
        if (currentCarForRevert.getMileage() > 10000) {
            System.out.printf("%s mileage decreased by %d kilometers%n",currentCarForRevert.getModelCar(),Math.abs(currentCarForRevert.getMileage() - currentKm));
        }
    }

    private static void refuel(Map<String, Car> carsMap, Car currentCarForRefuel, int fuelForRe) {
        int fuelCurrent = currentCarForRefuel.getFuel();
        currentCarForRefuel.setFuel(Math.min(fuelCurrent + fuelForRe, 75));
        System.out.printf("%s refueled with %d liters%n", currentCarForRefuel.getModelCar(),currentCarForRefuel.getFuel() - fuelCurrent);

    }

    private static void drive(Map<String, Car> carsMap, Car currentCar, int distance, int fuelNeeded) {
        int fuelIn = currentCar.getFuel();
        if (fuelIn < fuelNeeded) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            currentCar.setMileage(currentCar.getMileage() + distance);
            currentCar.setFuel(currentCar.getFuel() - fuelNeeded);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar.getModelCar(), distance,fuelNeeded);
            if (currentCar.getMileage() >= 100000) {
                carsMap.remove(currentCar.getModelCar());
                System.out.printf("Time to sell the %s!%n",currentCar.getModelCar());
            }

        }
    }

    public static class Car {
        String modelCar;
        int mileage;
        int fuel;

        public Car(String modelCar, int mileage, int fuel) {
            this.modelCar = modelCar;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getModelCar() {
            return modelCar;
        }

        public void setModelCar(String modelCar) {
            this.modelCar = modelCar;
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
            return String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", getModelCar(), getMileage(),getFuel());
        }
    }
}
