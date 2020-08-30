package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @DisplayName("이름을 가진 자동차가 정상적으로 생성 되는지 확인한다.")
    @Test
    void constructorTest() {
        final Car expected = new Car("jun");

        assertThat(new Car("jun"))
                .isInstanceOf(Car.class)
                .isEqualToComparingFieldByField(expected);
    }

    @DisplayName("자동차 전진 판단 기능.")
    @ParameterizedTest
    @MethodSource("provideInputForCanGo")
    void canGoTest(final int input, final boolean expected) {
        final Car car = new Car("jun");

        assertThat(car.canGo(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputForCanGo() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(9, true)
        );
    }
}
