package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
