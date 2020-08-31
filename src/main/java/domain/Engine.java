package domain;

import java.util.Objects;

public class Engine {
    private static final int MINIMUM_ENGINE_VALUE = 0;
    private static final int MAXIMUM_ENGINE_VALUE = 9;
    private static final int MINIMUM_RUNNING_VALUE = 4;
    private static final int INITIAL_RUNNING_COUNT = 0;
    private static final int RUNNING_UNIT = 1;

    private int runningCount;

    public Engine() {
        this.runningCount = INITIAL_RUNNING_COUNT;
    }

    public boolean canRunning(final int input) {
        validateValue(input);

        return MINIMUM_RUNNING_VALUE <= input;
    }

    private void validateValue(final int input) {
        if (input < MINIMUM_ENGINE_VALUE || input > MAXIMUM_ENGINE_VALUE) {
            throw new IllegalArgumentException(String.format("유효한 값이 아닙니다 : %d", input));
        }
    }

    public void run() {
        runningCount += RUNNING_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return runningCount == engine.runningCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(runningCount);
    }

    public int getRunningCount() {
        return runningCount;
    }
}
