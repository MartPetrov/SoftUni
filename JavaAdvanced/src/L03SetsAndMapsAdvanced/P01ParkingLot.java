package L03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] parts = line.split(", ");
            if (parts[0].equals("IN")) {
                parkingLot.add(parts[1]);
            } else if (parts[0].equals("OUT")) {
                parkingLot.remove(parts[1]);
            }
            line = scanner.nextLine();
        }
        if (!parkingLot.isEmpty()) {
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
