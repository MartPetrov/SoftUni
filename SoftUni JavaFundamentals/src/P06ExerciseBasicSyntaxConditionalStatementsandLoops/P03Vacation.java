package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int peopleNum = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String day = scanner.nextLine();
        double priceOne = 0;
        double disc = 0;
        double totalPrice = 0;
        switch (typePeople){
            case "Students":
                if (day.equals("Friday")){
                    priceOne = 8.45;
                } else if (day.equals("Saturday")){
                    priceOne = 9.80;
                } else {
                    priceOne = 10.46;
                }
                break;
            case  "Business":
                if (day.equals("Friday")){
                    priceOne = 10.90;
                } else if (day.equals("Saturday")){
                    priceOne = 15.60;
                } else {
                    priceOne = 16.00;
                }
                break;
            case "Regular":
                if (day.equals("Friday")){
                    priceOne = 15.00;
                } else if (day.equals("Saturday")){
                    priceOne = 20.00;
                } else {
                    priceOne = 22.50;
                }
                break;
        }

        if (typePeople.equals("Students") && peopleNum >= 30) {
            priceOne = priceOne * 0.85;
        } else if (typePeople.equals("Business") && peopleNum >= 100) {
            peopleNum -= 10;
        } else if (typePeople.equals("Regular") && peopleNum >= 10 && peopleNum <= 20) {
            priceOne = priceOne * 0.95;
        }
        totalPrice = peopleNum * priceOne;
        System.out.printf("Total price: %.2f", totalPrice);

    }
}

