package L11DefiningClasses.P01CarInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> listOfCars = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            String[] carsData = scanner.nextLine().split("\\s+");
            String brand = carsData[0];
            String model = carsData[1];
            int horsePower = Integer.parseInt(carsData[2]);

            Car car = new Car(brand,model,horsePower);
            listOfCars.add(car);
        }
        listOfCars.forEach(car -> System.out.println(car.carInfo()));
    }
}
