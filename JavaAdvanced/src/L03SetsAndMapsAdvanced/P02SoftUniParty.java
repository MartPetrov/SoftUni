package L03SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> people = new TreeSet<>();


        String reservationNumber = scanner.nextLine();

        while (!reservationNumber.equals("PARTY")) {

            char startingSymbol = reservationNumber.charAt(0);
            boolean isVipRegistration = Character.isDigit(startingSymbol);

            people.add(reservationNumber);
            reservationNumber = scanner.nextLine();
        }

        String guestReservation = scanner.nextLine();

        while (!guestReservation.equals("END")) {
            people.remove(guestReservation);
            guestReservation = scanner.nextLine();
        }

        System.out.println(people.size());
        System.out.println(String.join(System.lineSeparator(), people));


    }
}
