package domain;

public class Engine {
    private static final int MINIMUM_ENGINE_VALUE = 0;
    private static final int MAXIMUM_ENGINE_VALUE = 9;
    private static final int MINIMUM_RUNNING_VALUE = 4;

    public boolean canRunning(final int input) {
        validateValue(input);

        return MINIMUM_RUNNING_VALUE <= input;
    }

    private void validateValue(final int input) {
        if (input < MINIMUM_ENGINE_VALUE || input > MAXIMUM_ENGINE_VALUE) {
            throw new IllegalArgumentException(String.format("유효한 값이 아닙니다 : %d", input));
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Engine;
    }
}
