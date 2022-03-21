package Exam02;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantRarityMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("<->");
            String plantName = inputArr[0];
            int rarity = Integer.parseInt(inputArr[1]);
            plantRarityMap.put(plantName,rarity);
        }

            Map<String, List<Double>> plantRatingMap = new LinkedHashMap<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Exhibition")) {
                break;
            }
            String[] commandArr = Arrays.stream(command.split("[:/\\s-]")).filter(c ->!c.equals("")).toArray(String[]::new);
            String namePlant = commandArr[1];
            String commandType = commandArr[0];
            switch (commandType) {
                case "Rate":
                    double rating = Double.parseDouble(commandArr[2]);
                    if (plantRarityMap.containsKey(namePlant)) {
                        if (plantRatingMap.containsKey(namePlant)){
                            List<Double> plantRatingsList = plantRatingMap.get(namePlant);
                            plantRatingsList.add(rating);
                            plantRatingMap.put(namePlant, plantRatingsList);
                        } else {
                            plantRatingMap.put(namePlant, new ArrayList<>(Arrays.asList(rating)));
                        }
                    } else {
                        System.out.printf("error%n");
                    }
                    break;
                case "Update":
                    int updatedRarity = Integer.parseInt(commandArr[2]);
                    plantRarityMap.put(namePlant,updatedRarity);
                    break;
                case "Reset":
                    plantRatingMap.put(namePlant, Arrays.asList(0.00));
                    break;
            }
        }
        System.out.printf("Plants for the exhibition:%n");
        plantRarityMap.entrySet().stream().forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(),
                plantRatingMap.get(entry.getKey()).stream().mapToDouble(a->a).average().getAsDouble()));
    }
}
