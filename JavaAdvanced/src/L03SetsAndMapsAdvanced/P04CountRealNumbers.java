package L03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> ocurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (ocurrences.containsKey(numbers[i])){
                int current = ocurrences.get(numbers[i]);
                ocurrences.put(numbers[i],current+1);
            } else {
                ocurrences.put(numbers[i],1);
            }
        }

//        for (Double number : ocurrences.keySet()) {
//            System.out.printf("%.1f -> %d%n", number, ocurrences.get(number));
//        }

        for (Map.Entry<Double,Integer> entry : ocurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
