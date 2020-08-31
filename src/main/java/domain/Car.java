package domain;

import java.util.Objects;

public class Car {
    private final String name;
    private final Engine engine;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.engine = new Engine();
    }

    private void validName(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 이나 빈 값이 올 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 해주세요.");
        }
    }

    public void moveOrNotBy(final int value) {
        if (engine.canRunning(value)) {
            engine.run();
        }
    }

    public int findCurrentPosition() {
        return engine.getRunningCount();
    }

    public boolean isWinner(int winningValue) {
        return findCurrentPosition() == winningValue;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }
}
