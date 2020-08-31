package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private static final String SPACE = " ";
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String CAR_DELIMITER = ",";

    public static List<String> readCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

            String[] carNames = bufferedReader.readLine().split(CAR_DELIMITER, -1);

            validateCarNames(carNames);
            return Arrays.asList(carNames);
        }
        catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    private static void validateCarNames(String[] carNames) {
        for (String carName: carNames) {
            if(carName.contains(SPACE)) {
                throw new IllegalArgumentException("이름에 공백은 허용하지 않습니다.");
            }
        }
    }
}
