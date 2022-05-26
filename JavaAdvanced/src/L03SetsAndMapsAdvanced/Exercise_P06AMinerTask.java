package L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Double> resourceMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource = input;
            double quantity = Double.parseDouble(scanner.nextLine());
            if (!resourceMap.containsKey(resource)) {
                resourceMap.put(resource,quantity);
            } else {
                double currentQuantity = resourceMap.get(resource);
                resourceMap.put(resource,currentQuantity + quantity);
            }

            input = scanner.nextLine();
            }

        resourceMap.entrySet().forEach(resource -> System.out.printf("%s -> %.0f%n",resource.getKey(),resource.getValue()));
        }
    }
