package domain;

public class Car {
    private final String name;
    private final Engine engine;

    public Car(String name) {
        this.name = name;
        this.engine = new Engine();
    }

    public void move(final int value) {
        if (engine.canRunning(value)) {
            engine.run();
        }
    }

    public int findCurrentPosition() {
        return engine.getRunningCount();
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }
}
