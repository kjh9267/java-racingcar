package controller;

import domain.Car;
import domain.Race;
import domain.RandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    public static void run() {
        final Race race = createRace();
        final int round = inputRound();

    }

    private static int inputRound() {
        return InputView.readRound();
    }

    private static Race createRace() {
        try {
            List<String> names = InputView.readCarNames();
            List<Car> cars = createCars(names);
            return new Race(cars, new RandomGenerator());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return createRace();
        }
    }

    private static List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
