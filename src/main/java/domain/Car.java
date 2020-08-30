package domain;

public class Car {
    private final String name;
    private final Engine engine;
    private final int position = 0;

    public Car(String name) {
        this.name = name;
        this.engine = new Engine();
    }

    public String getName() {
        return name;
    }
}
