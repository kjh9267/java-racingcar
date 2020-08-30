package domain;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean canGo(final int input) {
        final boolean isBetweenFourAndNine = ((4 <= input) && (input <= 9));

        return isBetweenFourAndNine;
    }
}
