package FinalExam030422;

import java.util.*;
import java.util.stream.Collectors;

public class P03Degustation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> guestMealMap = new LinkedHashMap<>();
        int countUnlike = 0;
        while (!input.equals("Stop")) {
            String[] inputArr = input.split("-");
            String currentGuest = inputArr[1];
            String currentMeal = inputArr[2];
            switch (inputArr[0]) {
                case "Like":
                    if (guestMealMap.containsKey(currentGuest)) {
                        List<String> currentList = guestMealMap.get(currentGuest);
                        if (!currentList.contains(currentMeal)) {
                            currentList.add(currentMeal);
                        }
                    } else {
                        guestMealMap.put(currentGuest, new LinkedList<>());
                        List<String> currentList = guestMealMap.get(currentGuest);
                        currentList.add(currentMeal);
                    }

                    break;
                case "Dislike":
                    if (guestMealMap.containsKey(currentGuest)) {
                        List<String> currentList = guestMealMap.get(currentGuest);
                        if (currentList.contains(currentMeal)) {
                            currentList.remove(currentMeal);
                            System.out.printf("%s doesn't like the %s.%n", currentGuest, currentMeal);
                            countUnlike++;
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", currentGuest,currentMeal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.%n", currentGuest);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : guestMealMap.entrySet()) {
            String key = entry.getKey();
            List<String> allLikeMeal = entry.getValue();
            System.out.println(key +": "+ String.join(", " , allLikeMeal));
        }
            System.out.printf("Unliked meals: %d", countUnlike);


    }

}
