package P25AssociativeArraysExercise;

import java.util.*;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new LinkedHashMap<>();
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        Map<String, Integer> junks = new LinkedHashMap<>();
        boolean isOver = false;
        while (!isOver) {

            String input = scanner.nextLine();
            String[] inputData = input.split(" ");

            for (int index = 0; index < inputData.length; index = index + 2) {
                int quantity = Integer.parseInt(inputData[index]);
                String material = inputData[index + 1].toLowerCase();

                if (materialsMap.containsKey(material)) {
                    int currentQuality = materialsMap.get(material);
                    materialsMap.put(material, currentQuality + quantity);
                    if (materialsMap.get(material) >= 250) {
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else if (material.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                        }
                        materialsMap.put(material, materialsMap.get(material) - 250);
                        isOver = true;
                        break;
                    }

                } else {
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else {
                        int currentQuantity = junks.get(material);
                        junks.put(material, currentQuantity + quantity);
                    }
                }

            }
        }

        materialsMap.entrySet().stream()
                        .forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(), entry.getValue()));


        junks.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


    }
}
