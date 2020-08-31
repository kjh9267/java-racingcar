package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ));
    }

    @DisplayName("Cars 클래스 생성자 테스트")
    @Test
    void constructorTest() {
        final Race race = new Race(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ));

        assertThat(race).isInstanceOf(Race.class);
    }
}
