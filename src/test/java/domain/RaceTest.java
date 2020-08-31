package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @DisplayName("Race 클래스 생성할 때 null이거나 비어있는 cars일 때 예외처리")
    @ParameterizedTest
    @NullAndEmptySource
    void constructorTest2(List<Car> input) {
        assertThatThrownBy(() -> new Race(input, new RandomGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null이나 빈 값");
    }

    @DisplayName("Race 클래스 생성할 때 null인 randomGenerator일 때 예외처리")
    @ParameterizedTest
    @NullSource
    void constructorTest3(RandomGenerator randomGenerator) {
        assertThatThrownBy(() -> new Race(Arrays.asList(
                new Car("k3"),
                new Car("k5"),
                new Car("k7")
        ), randomGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @DisplayName("레이스 한 라운드 진행 테스트 정상 동작 확인")
    @Test
    void racingOneRoundTest() {
        race.racingOneRound();
    }

    @DisplayName("레이스의 winningValue를 구하는 기능 정상 동작 확인")
    @Test
    void calculateWinningValueTest() {
        final Car car1 = new Car("a");
        car1.moveOrNotBy(9);
        car1.moveOrNotBy(9);
        car1.moveOrNotBy(9);

        final Car car2 = new Car("b");
        car2.moveOrNotBy(9);
        car2.moveOrNotBy(9);
        final Race race = new Race(Arrays.asList(car1, car2), new RandomGenerator());

        assertThat(race.calculateWinningValue()).isEqualTo(3);
    }

    @DisplayName("우승자들이 2명일 때 올바르게 찾는지 확인")
    @Test
    void findWinnersTest() {
        final Car car1 = new Car("a");
        car1.moveOrNotBy(9);
        car1.moveOrNotBy(9);
        car1.moveOrNotBy(9);

        final Car car2 = new Car("b");
        car2.moveOrNotBy(9);
        car2.moveOrNotBy(9);

        final Car car3 = new Car("c");
        car3.moveOrNotBy(9);
        car3.moveOrNotBy(9);
        car3.moveOrNotBy(9);

        final Race race = new Race(Arrays.asList(car1, car2, car3), new RandomGenerator());

        assertThat(race.findWinners().size()).isEqualTo(2);
    }
}
