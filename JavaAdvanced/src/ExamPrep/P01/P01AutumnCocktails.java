package ExamPrep.P01;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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

            if (isZero(currentFreshness, currentIngredients, ingredients, freshnessLevel)) {
                continue;
            }
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
                int currentIngredientsRemove = ingredients.peek();
               ingredients.poll();
                ingredients.offerLast(currentIngredientsRemove + 5);

            }

        }
        if (isMakeAllCocktail(cocktailMap) && cocktailMap.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }


        if (!ingredients.isEmpty()) {
            int sumOfIngredients = 0;
            int ingredientsSize = ingredients.size();
            for (int i = 0; i < ingredientsSize; i++) {
                int currentElement = ingredients.pop();
                sumOfIngredients += currentElement;
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


    private static boolean isMakeAllCocktail(Map<String, Integer> cocktailMap) {
        boolean isValid = true;
        for (Map.Entry<String, Integer> entry : cocktailMap.entrySet()) {
            if (entry.getValue() == 0) {
                isValid = false;
            }
        }
        return isValid;
    }

    private static boolean isZero(int currentFreshness, int currentIngredients, ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshnessLevel) {
        if (currentIngredients == 0) {
            ingredients.poll();
            return true;
        }
        if (currentFreshness == 0) {
            freshnessLevel.pop();
            return true;
        }
        return false;
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
//TODO Find where is wrong

}
