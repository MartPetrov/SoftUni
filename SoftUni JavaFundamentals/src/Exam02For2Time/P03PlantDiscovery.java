package Exam02For2Time;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Plant> plantsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            String name = plantInfo[0];
            int rarity = Integer.parseInt(plantInfo[1]);
            if (!isValidName(plantsMap, name)) {
                Plant currentPlant = new Plant(name, rarity, new LinkedList<>());
                plantsMap.put(name, currentPlant);
            } else {
                Plant currentPlant = plantsMap.get(name);
                currentPlant.setRarity(rarity);
            }

        }

        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandArr = command.split("[: -]+");
            String commandToSwitch = commandArr[0];
            String name = commandArr[1];
            if (!isValidName(plantsMap, name)) {
                System.out.printf("error%n");

            } else {
                Plant current = plantsMap.get(name);
                switch (commandToSwitch) {
                    case "Rate":
                        int rating = Integer.parseInt(commandArr[2]);
                        plantsMap.get(name).getRating().add(rating);
                        break;
                    case "Update":
                        int rarity = Integer.parseInt(commandArr[2]);
                        current.setRarity(rarity);
                        break;
                    case "Reset":
                        current.setRating(new LinkedList<>());
                        break;
                    default:
                        System.out.println("error");
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Plants for the exhibition:%n");
        for (Plant plant : plantsMap.values()) {
            System.out.println(plant);
        }

    }

    private static boolean isValidName(Map<String, Plant> plantsMap, String name) {
        if (plantsMap.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }


    public static class Plant {
        String name;
        int rarity;
        List<Integer> rating;

        public Plant(String name, int rarity, List<Integer> rating) {
            this.name = name;
            this.rarity = rarity;
            this.rating = rating;
        }


        @Override
        public String toString() {
            return String.format("- %s; Rarity: %d; Rating: %.2f", getName(), getRarity(), getAverageRating());
        }

        private Double getAverageRating() {
            return this.rating.stream().mapToDouble(e -> e).average().orElse(0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Integer> getRating() {
            return rating;
        }

        public void setRating(List<Integer> rating) {
            this.rating = rating;
        }
    }
}