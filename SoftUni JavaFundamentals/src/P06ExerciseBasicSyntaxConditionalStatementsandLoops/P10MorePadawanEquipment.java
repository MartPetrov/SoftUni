package P06ExerciseBasicSyntaxConditionalStatementsandLoops;

import java.util.Scanner;

public class P10MorePadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//•	The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
//•	The count of students – integer in the range [0…100].
//•	The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
//•	The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
//•	The price of belts for a single belt – the floating-point number in the range [0.00…100.00].


        double money = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double priceSaber = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double realSaber = Math.ceil(studentsCount * 1.1);
        int freeBelts = studentsCount / 6;
        int realBelts = studentsCount - freeBelts;

        double allPrice = (studentsCount * priceRobes) + (realBelts * priceBelts) + (realSaber * priceSaber);

        if (money >= allPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", allPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(allPrice- money));
        }
    }
}
