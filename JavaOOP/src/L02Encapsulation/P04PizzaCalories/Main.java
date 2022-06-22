package L02Encapsulation.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pizzaData = scanner.nextLine();
        String pizzaName = pizzaData.split(" ")[1];
        int toppingsNumber = Integer.parseInt(pizzaData.split(" ")[2]);
        Pizza pizza = new Pizza(pizzaName, toppingsNumber);

        String doughData = scanner.nextLine();
        String flourType = doughData.split(" ")[1];
        String bakingTechnique = doughData.split(" ")[2];
        double weight = Double.parseDouble(doughData.split(" ")[3]);
        Dough dough = new Dough(flourType,bakingTechnique,weight);
        pizza.setDough(dough);

        String toppingData = scanner.nextLine();

        while (!toppingData.equals("END")) {
            String toppingType = toppingData.split(" ")[1];
            double toppingWeight = Double.parseDouble(toppingData.split(" ")[2]);
            Topping topping = new Topping(toppingType,toppingWeight);
            pizza.addTopping(topping);

            toppingData = scanner.nextLine();
        }
        System.out.println(pizza);

    }
}
