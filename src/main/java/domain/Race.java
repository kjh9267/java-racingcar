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

    public void racingBy(int round) {
        for (int i = 0; i < round; i++) {
            this.racingOneRound();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
