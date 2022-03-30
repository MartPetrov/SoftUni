package Exam03For2Time;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeed {

   static class Cars{
        String name;
        int kilometers;
        int fuel;

       public Cars(String nameCar, int kilometers, int fuel) {

           this.name = nameCar;
           this.kilometers = kilometers;
           this.fuel = fuel;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public int getKilometers() {
           return kilometers;
       }

       public void setKilometers(int kilometers) {
           this.kilometers = kilometers;
       }

       public int getFuel() {
           return fuel;
       }

       public void setFuel(int fuel) {
           this.fuel = fuel;
       }
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Cars> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carsParram = scanner.nextLine().split("\\|");
            Cars cars = new Cars(carsParram[0],Integer.parseInt(carsParram[1]),Integer.parseInt(carsParram[2]));
            carsMap.put(cars.getName(), cars);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandArr = command.split(" : ");
            switch (commandArr[0]) {
                case "Drive":
                    String currentCars = commandArr[1];
                    int distanceToDrive = Integer.parseInt(commandArr[2]);
                    int fuelNeeded = Integer.parseInt(commandArr[3]);
                    drive(carsMap,currentCars,distanceToDrive,fuelNeeded);
                    break;
                case "Refuel":
                    String currentCarsToRefuel = commandArr[1];
                    int fuelToRefuel = Integer.parseInt(commandArr[2]);
                    refuel(carsMap,currentCarsToRefuel,fuelToRefuel);
                    break;
                case "Revert":
                    String currentCarToRevert = commandArr[1];
                    int kmToRevert = Integer.parseInt(commandArr[2]);
                    revert(carsMap,currentCarToRevert,kmToRevert);
                    break;
            }

            command = scanner.nextLine();
        }
        for (Cars cars : carsMap.values()) {
            System.out.println(cars.getName() + " -> Mileage: " + cars.getKilometers() + " kms, Fuel in the tank: " + cars.getFuel() +" lt.");
        }
    }

    private static void drive(Map<String, Cars> carsMap, String currentCars, int distanceToDrive, int fuelNeeded) {
        Cars cars = carsMap.get(currentCars);
        if (cars.getFuel() > fuelNeeded) {
            cars.setFuel(cars.getFuel() - fuelNeeded);
            int currentKm = cars.getKilometers();
            cars.setKilometers(currentKm + distanceToDrive);
            System.out.println(currentCars + " driven for "+distanceToDrive+" kilometers. " + fuelNeeded+" liters of fuel consumed.");
        } else {
            System.out.println("Not enough fuel to make that ride");
        }
        if (cars.getKilometers() >= 100000) {
            System.out.println("Time to sell the "+ cars.getName()+ "!");
            carsMap.remove(currentCars);
        }
    }

    private static void refuel(Map<String, Cars> carsMap, String currentCarsToRefuel, int fuelToRefuel) {
        Cars cars = carsMap.get(currentCarsToRefuel);
        int currentFuel = cars.getFuel();
        cars.setFuel(Math.min(currentFuel + fuelToRefuel,75));
        System.out.printf("%s refueled with %d liters%n", cars.getName(), cars.getFuel() - currentFuel);
    }

    private static void revert(Map<String, Cars> carsMap, String currentCarToRevert, int kmToRevert) {
        Cars cars = carsMap.get(currentCarToRevert);
        int currentKm = cars.getKilometers();
        cars.setKilometers(Math.max(currentKm - kmToRevert, 10000));
        if (cars.getKilometers() > 10000) {
            System.out.printf("%s mileage decreased by %d kilometers%n", cars.getName(), currentKm - cars.getKilometers());
        }
    }
}
