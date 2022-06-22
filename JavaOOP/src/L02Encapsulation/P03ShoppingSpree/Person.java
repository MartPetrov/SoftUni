package L02Encapsulation.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            products.add(product);
            System.out.printf("%s bought %s%n",this.name, product.getName());
            this.money -= product.getCost();

        } else {
            String message = String.format("%s can't afford %s",this.name,product.getName());
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }


}
