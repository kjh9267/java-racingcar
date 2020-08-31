package domain;

import java.util.List;
import java.util.Objects;

public class Race {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Race(List<Car> cars, RandomGenerator randomGenerator) {
        validateCars(cars);
        validateRandomGenerator(randomGenerator);
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    private void validateRandomGenerator(final RandomGenerator randomGenerator) {
        if (Objects.isNull(randomGenerator)) {
            throw new IllegalArgumentException("randomGenerator는 null이 올 수 없습니다.");
        }
    }

    private void validateCars(final List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("cars는 null이나 빈 값이 올 수 없습니다.");
        }
    }

    public void racingOneRound() {
        for (Car car: cars) {
            car.moveOrNotBy(randomGenerator.generate());
        }
    }

    public int calculateWinningValue() {
        return cars.stream()
                .mapToInt(Car::findCurrentPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}
