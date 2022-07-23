package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.MAX_VALUE;
import static hexlet.code.Engine.NO;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.RESULT_INDEX;
import static hexlet.code.Engine.TWO;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.YES;
import static hexlet.code.Engine.YES_NO_RULES;
import static hexlet.code.Engine.getRandValue;

public class Prime {
    private static final int MIN_PRIME_NUMBER = 2;
    private static final String PRIME = "prime";

    public static void startGame() {
        String[][] questions = new String[WIN_COUNT][TWO];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt = getRandValue(MAX_VALUE - MIN_PRIME_NUMBER) + MIN_PRIME_NUMBER;
            questions[i][QUESTION_INDEX] = Integer.toString(randInt);
            questions[i][RESULT_INDEX] = isPrime(randInt)  ? YES : NO;
        }
        Engine.execute(String.format(YES_NO_RULES, PRIME), questions);
    }

    private static boolean isPrime(int value) {
        boolean isPrime = false;
        for (int i = MIN_PRIME_NUMBER; i <= value; i++) {
            if (i == value) {
                isPrime = true;
            } else if (value % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
