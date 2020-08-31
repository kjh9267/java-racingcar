package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @DisplayName("Cars 클래스 생성자 테스트")
    @Test
    void constructorTest() {
        final Cars cars = new Cars();

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @DisplayName("Cars에 자동차를 추가하는 기능 테스트")
    @Test
    void addCarTest() {
        Car car = new Car("k3");

        cars.addCar(car);

        assertThat(cars.getCars().contains(car))
                .isEqualTo(true);
    }
}
