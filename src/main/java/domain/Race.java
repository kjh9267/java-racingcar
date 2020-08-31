package domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Race(List<Car> cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public void racingOneRound() {
        for (Car car: cars) {
            car.moveOrNotBy(randomGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
