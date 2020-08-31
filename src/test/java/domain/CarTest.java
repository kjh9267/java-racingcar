package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jun");
    }

    @DisplayName("이름을 가진 자동차가 정상적으로 생성 되는지 확인한다.")
    @Test
    void constructorTest() {
        final Car expected = new Car("jun");

        assertThat(car)
                .isInstanceOf(Car.class)
                .isEqualToComparingFieldByField(expected);
    }

    @DisplayName("이름이 null일 경우 예외 처리 하기.")
    @ParameterizedTest
    @NullAndEmptySource
    void constructorTest2(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 null 이나 빈 값이 올 수 없습니다.");
    }


    @DisplayName("이름이 5자가 넘을 경우 예외 처리 하기.")
    @Test
    void constructorTest3() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하로 해주세요.");
    }

    @DisplayName("여러 자동차가 같은 값을 받았을 때 똑같이 움직이는지 확인한다.")
    @Test
    void moveTest() {
        final Car k3 = new Car("k3");

        car.moveOrNotBy(9);
        k3.moveOrNotBy(9);
        car.moveOrNotBy(0);
        k3.moveOrNotBy(0);

        assertThat(car.findCurrentPosition()).isEqualTo(k3.findCurrentPosition());
    }

    @DisplayName("2만큼 움직인 자동차의 현재 위치가 2인지 확인한다.")
    @Test
    void findCurrentPositionTest() {
        car.moveOrNotBy(9);
        car.moveOrNotBy(8);

        final int currentPosition = car.findCurrentPosition();

        assertThat(currentPosition).isEqualTo(2);
    }

    @DisplayName("5칸 이동한 차와 우승자의 값이 주어졌을 때 우승자인지 판별")
    @ParameterizedTest
    @MethodSource("provideInputForIsWinner")
    void isWinnerTest(int winningValue, boolean expected) {
        final int carPosition = 5;

        for (int i = 0; i < carPosition; i++) {
            car.moveOrNotBy(9);
        }

        assertThat(car.isWinner(winningValue))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputForIsWinner() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(6, false),
                Arguments.of(7, false),
                Arguments.of(8, false)
        );
    }
}
