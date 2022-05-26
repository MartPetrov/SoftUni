package L06DefiningClasses.P02CarConstructors;


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
            Car car;
            if (carsData.length == 1) {
                car = new Car(brand);
            } else {
                String model = carsData[1];
                int horsePower = Integer.parseInt(carsData[2]);
                car = new Car(brand, model, horsePower);
            }

            listOfCars.add(car);
        }
        listOfCars.forEach(car -> System.out.println(car.carInfo()));
    }
}
