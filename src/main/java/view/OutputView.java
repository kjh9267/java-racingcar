package view;

import domain.Car;
import domain.Race;

public class OutputView {
    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printRoundResult(Race race) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car: race.getCars()) {
            stringBuilder.append(String.format("%s : ", car.getName()));
            for (int i = 0; i < car.findCurrentPosition(); i++) {
                stringBuilder.append(DASH);
            }
            stringBuilder.append(NEW_LINE);
        }

        System.out.println(stringBuilder.toString());
    }
}
