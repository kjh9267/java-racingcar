package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomGeneratorTest {

    @DisplayName("난수 생성기 생성자 테스트")
    @Test
    void constructorTest() {
        assertThat(new RandomGenerator()).isInstanceOf(RandomGenerator.class);
    }

    @DisplayName("0 ~ 9 사이의 값이 생성 되는지 확인.")
    @Test
    void generateTest() {
        final RandomGenerator randomGenerator = new RandomGenerator();

        for (int i = 0; i < 100; i++) {
            assertThat(randomGenerator.generate()).isBetween(0, 9);
        }
    }
}
