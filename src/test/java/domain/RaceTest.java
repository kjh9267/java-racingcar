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
        ), new RandomGenerator());
    }

    @DisplayName("Race 클래스 생성자 테스트")
    @Test
    void constructorTest() {
        final Race race = new Race(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ), new RandomGenerator());

        assertThat(race).isInstanceOf(Race.class);
    }

    @DisplayName("레이스 한 라운드 진행 테스트 정상 동작 확인")
    @Test
    void racingOneRoundTest() {
        race.racingOneRound();
    }

    @DisplayName("레이스 전달받은 횟수만큼 라운드 진행 동작 확인")
    @Test
    void racingByTest() {
        race.racingBy(4);
    }
}
