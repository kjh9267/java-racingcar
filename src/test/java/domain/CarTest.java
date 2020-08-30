package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

        car.move(9);
        k3.move(9);
        car.move(0);
        k3.move(0);

        assertThat(car.findCurrentPosition()).isEqualTo(k3.findCurrentPosition());
    }

    @DisplayName("2만큼 움직인 자동차의 현재 위치가 2인지 확인한다.")
    @Test
    void findCurrentPositionTest() {
        car.move(9);
        car.move(8);

        final int currentPosition = car.findCurrentPosition();

        assertThat(currentPosition).isEqualTo(2);
    }
}
