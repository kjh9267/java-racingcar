package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EngineTest {
    private Engine engine;

    @BeforeEach
    void setUp() {
        engine = new Engine();
    }

    @DisplayName("엔진이 정상적으로 생성되는지 확인한다.")
    @Test
    void constructorTest() {
        assertThat(engine).isInstanceOf(Engine.class);
    }

    @DisplayName("엔진 작동 판단 기능.")
    @ParameterizedTest
    @MethodSource("provideInputForCanGo")
    void canGoTest(final int input, final boolean expected) {
        assertThat(engine.canRunning(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputForCanGo() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(9, true)
        );
    }

    @DisplayName("canGo메서드에 input이 0~9 사이가 아닐 때 예외처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 10, Integer.MAX_VALUE})
    void canGoTest2(final int input) {
        assertThatThrownBy(() -> engine.canRunning(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 값이 아닙니다 : %d", input);
    }
}
