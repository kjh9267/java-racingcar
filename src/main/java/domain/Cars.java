package domain;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
