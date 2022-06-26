import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01ItsChocolateTime {
    public static final double Milk_Chocolate = 30;
    public static final double Dark_Chocolate = 50;
    public static final double Baking_Chocolate = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] milkArr = scanner.nextLine().split(" ");
        String[] cacaoArr = scanner.nextLine().split(" ");

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cacao = new ArrayDeque<>();

        for (int i = 0; i < milkArr.length; i++) {
            milk.offer(Double.parseDouble(milkArr[i]));
        }
        for (int i = 0; i < cacaoArr.length; i++) {
            cacao.push(Double.parseDouble(cacaoArr[i]));
        }


        Map<String,Integer> mapOfChocolate = new TreeMap<>();
        mapOfChocolate.put("Milk Chocolate", 0);
        mapOfChocolate.put("Dark Chocolate", 0);
        mapOfChocolate.put("Baking Chocolate", 0);


        while (!milk.isEmpty() && !cacao.isEmpty()) {
            double currentMilk = milk.peek();
            double currentCacao = cacao.peek();
            double percentage = (currentCacao / (currentMilk + currentCacao))* 100;

            if (percentage == Milk_Chocolate) {
                mapOfChocolate.put("Milk Chocolate", mapOfChocolate.get("Milk Chocolate") + 1);
                milk.poll();
                cacao.pop();
            } else if (percentage == Dark_Chocolate) {
                mapOfChocolate.put("Dark Chocolate", mapOfChocolate.get("Dark Chocolate") + 1);
                milk.poll();
                cacao.pop();

            } else if (percentage == Baking_Chocolate) {
                mapOfChocolate.put("Baking Chocolate", mapOfChocolate.get("Baking Chocolate") + 1);
                milk.poll();
                cacao.pop();

            } else {
                milk.poll();
                cacao.pop();
                milk.offerLast(currentMilk + 10);
            }
        }

        boolean isAllChocolate = true;
        for (Map.Entry<String, Integer> entry : mapOfChocolate.entrySet()) {
            if (entry.getValue() == 0) {
                isAllChocolate = false;
            }
        }
        if (isAllChocolate) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : mapOfChocolate.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.printf(" # %s --> %d%n", entry.getKey(),entry.getValue());
            }
        }


    }
}
