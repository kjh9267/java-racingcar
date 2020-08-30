package domain;

import java.util.Random;

public class RandomGenerator extends Random {

    public int generate() {
        return super.nextInt(10);
    }
}
