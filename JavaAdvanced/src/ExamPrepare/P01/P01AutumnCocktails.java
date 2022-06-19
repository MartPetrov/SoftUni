package ExamPrepare.P01;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).filter(e -> e != 0).toArray();
        int[] freshnessLevelArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i = 0; i < ingredientsArr.length; i++) {
            ingredients.offer(ingredientsArr[i]);
        }

        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();
        for (int i = 0; i < freshnessLevelArr.length; i++) {
            freshnessLevel.push(freshnessLevelArr[i]);
        }

        Map<String, Integer> cocktailMap = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int currentIngredients = ingredients.peek();
            int currentFreshness = freshnessLevel.peek();
            int multiplication = currentIngredients * currentFreshness;

            String name = "";
            if (multiplication == 150) {
                name = "Pear Sour";
                fillMap(cocktailMap, name, ingredients, freshnessLevel);
            } else if (multiplication == 250) {
                name = "The Harvest";
                fillMap(cocktailMap, name, ingredients, freshnessLevel);
            } else if (multiplication == 300) {
                name = "Apple Hinny";
                fillMap(cocktailMap, name, ingredients, freshnessLevel);
            } else if (multiplication == 400) {
                name = "High Fashion";
                fillMap(cocktailMap, name, ingredients, freshnessLevel);
            } else {
                freshnessLevel.pop();
                ingredients.poll();
                ingredients.offer(currentIngredients + 5);
            }

        }
        if (isValidMap(cocktailMap)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }


        if (!ingredients.isEmpty()) {
            int sumOfIngredients = 0;
            for (Integer ingredient : ingredients) {
                sumOfIngredients += ingredient;
            }
            System.out.println("Ingredients left: " + sumOfIngredients);
        }

        if (!cocktailMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : cocktailMap.entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
                }
            }
        }

    }


    private static void fillMap(Map<String, Integer> cocktailMap, String name, ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshnessLevel) {
        if (!cocktailMap.containsKey(name)) {
            cocktailMap.put(name, 1);
        } else {
            int current = cocktailMap.get(name);
            cocktailMap.put(name, current + 1);
        }
        ingredients.poll();
        freshnessLevel.pop();
    }


    private static boolean isValidMap(Map<String, Integer> cocktailMap) {
        if (cocktailMap.containsKey("Pear Sour") &&
                cocktailMap.containsKey("The Harvest") &&
                cocktailMap.containsKey("Apple Hinny") &&
                cocktailMap.containsKey("High Fashion")) {
            if (isMakeAllCocktail(cocktailMap)) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private static boolean isMakeAllCocktail(Map<String, Integer> cocktailMap) {
        boolean isValid = true;
        for (Map.Entry<String, Integer> entry : cocktailMap.entrySet()) {
            if (entry.getValue() == 0) {
                isValid = false;
            }
        }
        return isValid;
    }

}
