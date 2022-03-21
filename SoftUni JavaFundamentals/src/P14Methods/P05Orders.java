package P14Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeProduct = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        double totalPrice = onePrice(typeProduct, price) * quantity;
        System.out.printf("%.2f", totalPrice);

    }
    public static double onePrice (String type, double price) {

        if (type.equals("coffee")) {
            price = 1.50;
        }else if (type.equals("water")) {
            price = 1.00;
        }else if (type.equals("coke")) {
            price = 1.40;
        }else if (type.equals("snacks")) {
            price = 2.00;
        }
        return price;
    }
}
