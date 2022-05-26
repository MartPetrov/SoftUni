package L03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise_P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] data = input.split("");
        Map<String, Integer> elementMap = new TreeMap<>();
        for (int curel = 0; curel < data.length; curel++) {
            if (!elementMap.containsKey(data[curel])){
                elementMap.put(data[curel], 1);
            } else {
                int currentCount = elementMap.get(data[curel]);
                elementMap.put(data[curel],currentCount +1);
            }

        }
        if (!input.equals("")) {
            elementMap.entrySet().forEach(el -> System.out.printf(el.getKey() + ": " + el.getValue() + " time/s%n"));
        }
    }
}
