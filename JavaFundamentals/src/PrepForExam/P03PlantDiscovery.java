package com.PrepForExam;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPlants = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plantMap = new LinkedHashMap<>();
        for (int i = 0; i < numPlants; i++) {
            String[] lineInfoPlants = scanner.nextLine().split("<->");
            String name = lineInfoPlants[0];
            int rarity = Integer.parseInt(lineInfoPlants[1]);
            if (!isValidName(plantMap, name)) {
                Plant plant = new Plant(name, rarity, new LinkedList<>());
                plantMap.put(name, plant);
            } else {
                Plant current = plantMap.get(name);
                current.setRarity(rarity);
            }

        }

        String[] commandArr = scanner.nextLine().split("[: -]+");
        while (!commandArr[0].equals("Exhibition")) {
            if (!isValidName(plantMap, commandArr[1])) {
                System.out.printf("error%n");
            } else {
                Plant currentPlant = plantMap.get(commandArr[1]);
                switch (commandArr[0]) {
                    case "Rate":

                        double rating = Double.parseDouble(commandArr[2]);
                        List<Double> currentRating = currentPlant.getListOfRatings();
                        currentRating.add(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(commandArr[2]);
                        currentPlant.setRarity(newRarity);
                        break;
                    case "Reset":
                        currentPlant.setListOfRatings(new LinkedList<>());
                        break;
                    default:
                        System.out.printf("error%n");
                }
            }
            commandArr = scanner.nextLine().split("[: -]+");
        }
        System.out.printf("Plants for the exhibition:%n");
        for (Plant plant : plantMap.values()) {
            System.out.println(plant);
        }
    }

    private static boolean isValidName(Map<String, Plant> plantMap, String name) {
        return plantMap.containsKey(name);
    }

    public static class Plant {
        String plantName;
        int rarity;
        List<Double> listOfRatings;

        public Plant(String plantName, int rarity, List<Double> listOfRatings) {
            this.plantName = plantName;
            this.rarity = rarity;
            this.listOfRatings = listOfRatings;
        }

        public String getPlantName() {
            return plantName;
        }

        public void setPlantName(String plantName) {
            this.plantName = plantName;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getListOfRatings() {
            return listOfRatings;
        }

        public void setListOfRatings(List<Double> listOfRatings) {
            this.listOfRatings = listOfRatings;
        }

        @Override
        public String toString() {
            return String.format("- %s; Rarity: %d; Rating: %.2f", getPlantName(), getRarity(), getListOfRatings().stream().mapToDouble(e -> e).average().orElse(0));
        }
    }
}
