package ExamPrepare.P03.dealership;

import java.util.ArrayList;
import java.util.Collection;

public class Dealership {
    public int capacity;
    public String name;
    public Collection<Car> data;

    public Dealership(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            data.add(car);
        }
    }


    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int lastYear = 0;
        for (Car car : data) {
            if (car.getYear() > lastYear) {
                lastYear = car.getYear();
                latestCar = car;
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car getCar = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                getCar = car;
            }
        }
        return getCar;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car ExamPrep.P03.dealership %s:%n", this.name));
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
