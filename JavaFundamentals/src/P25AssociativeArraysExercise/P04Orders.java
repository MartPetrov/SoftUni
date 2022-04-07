package P25AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Double> PriceMap = new LinkedHashMap<>();
        Map<String, Integer> QuantityMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            List <String>  dataList = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            String product = dataList.get(0);
            double price = Double.parseDouble(dataList.get(1));
            int quantities = Integer.parseInt(dataList.get(2));

            if (!PriceMap.containsKey(product)) {
                PriceMap.put(product, price * quantities);
                QuantityMap.put(product, quantities);
            } else {

                int currentQuantity = QuantityMap.get(product);
                QuantityMap.put(product,currentQuantity + quantities);
                int currentQuantityRe = QuantityMap.get(product);
                PriceMap.put(product,price * currentQuantityRe);
            }

            input = scanner.nextLine();
        }


        for (Map.Entry<String, Double> entry : PriceMap.entrySet()) {
                String key = entry.getKey();
                double allPrice = entry.getValue();
                System.out.printf("%s -> %.2f%n", key, allPrice);

        }
    }
}
