package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ));
    }

    @DisplayName("Cars 클래스 생성자 테스트")
    @Test
    void constructorTest() {
        final Cars cars = new Cars(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ));

        assertThat(cars).isInstanceOf(Cars.class);
    }
}
