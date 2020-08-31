package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    @DisplayName("Cars 클래스 생성자 테스트")
    @Test
    void constructorTest() {
        final Cars cars = new Cars();

        assertThat(cars).isInstanceOf(Cars.class);
    }
}
