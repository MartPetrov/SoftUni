package ExamPrepare.P01;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquidsDeque = new ArrayDeque<>();
        for (int integer : liquidsArr) {
            liquidsDeque.offer(integer);
        }
        ArrayDeque<Integer> ingredientsDeque = new ArrayDeque<>();
        for (int integer : ingredientsArr) {
            ingredientsDeque.push(integer);
        }

        Map<Integer, String> foodMapSearch = new HashMap<>();
        foodMapSearch.put(25, "Biscuit");
        foodMapSearch.put(50, "Cake");
        foodMapSearch.put(75, "Pastry");
        foodMapSearch.put(100, "Pie");

        Map<String, Integer> foodMapAdd = new LinkedHashMap<>();
        foodMapAdd.put("Biscuit", 0);
        foodMapAdd.put("Cake", 0);
        foodMapAdd.put("Pie", 0);
        foodMapAdd.put("Pastry", 0);

        while (liquidsDeque.size() != 0 && ingredientsDeque.size() != 0) {
            int currentLiquids = liquidsDeque.peek();
            int currentIngredients = ingredientsDeque.peek();

            int currentSum = currentLiquids + currentIngredients;
            if (foodMapSearch.containsKey(currentSum)) {
                String currentFoodToAdd = foodMapSearch.get(currentSum);
                int currentCount = foodMapAdd.get(currentFoodToAdd);
                foodMapAdd.put(currentFoodToAdd, currentCount + 1);
                liquidsDeque.poll();
                ingredientsDeque.pop();
            } else {
                liquidsDeque.poll();
                ingredientsDeque.pop();
                ingredientsDeque.push(currentIngredients + 3);
            }
        }

        printAll(liquidsDeque, ingredientsDeque, foodMapAdd);
    }

    private static void printAll(ArrayDeque<Integer> liquidsDeque, ArrayDeque<Integer> ingredientsDeque, Map<String, Integer> foodMapAdd) {
        printFirstLine(foodMapAdd);
        printSecondLine(liquidsDeque);
        printThirdLine(ingredientsDeque);
        printAllInMap(foodMapAdd);
    }

    private static void printAllInMap(Map<String, Integer> foodMapAdd) {
        foodMapAdd.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void printThirdLine(ArrayDeque<Integer> ingredientsDeque) {
        if (!ingredientsDeque.isEmpty()) {
            System.out.print("Ingredients left: ");
            int size = ingredientsDeque.size();
            for (int i = 1; i <= size; i++) {
                if (i == size) {
                    System.out.println(ingredientsDeque.pop());
                } else {
                    System.out.print(ingredientsDeque.pop() + ", ");
                }
            }
        } else {
            System.out.println("Ingredients left: none");
        }
    }

    private static void printSecondLine(ArrayDeque<Integer> liquidsDeque) {
        if (!liquidsDeque.isEmpty()) {
            System.out.print("Liquids left: ");
            int size = liquidsDeque.size();
            for (int i = 1; i <= size; i++) {
                if (i == size) {
                    System.out.println(liquidsDeque.pop());
                } else {
                    System.out.print(liquidsDeque.pop() + ", ");
                }
            }
        } else {
            System.out.println("Liquids left: none");
        }
    }


    private static void printFirstLine(Map<String, Integer> foodMapAdd) {
        if (foodMapAdd.containsValue(0)) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

    }
}
