package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.RESULT_INDEX;
import static hexlet.code.Engine.TWO;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.getRandValue;

public class Gcd {
    private static final String GCD_RULES = "Find the greatest common divisor of given numbers.";
    private static final String GCD_QUESTION = "%d %d";
    public static void startGame() {
        String[][] questions = new String[WIN_COUNT][TWO];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt1 = getRandValue();
            int randInt2 = getRandValue();
            questions[i][QUESTION_INDEX] = String.format(GCD_QUESTION, randInt1, randInt2);
            questions[i][RESULT_INDEX] = Integer.toString(getGcd(randInt1, randInt2));
        }
        Engine.execute(GCD_RULES, questions);
    }
    private static int getGcd(int mod1, int mod2) {
        try {
            int mod = Math.max(mod1, mod2) % Math.min(mod1, mod2);
            if (mod != 0) {
                while (mod > 0) {
                    mod1 = mod2;
                    mod2 = mod;
                    mod = mod1 % mod2;
                }
            }
        } catch (ArithmeticException e) {
            return 1;
        }
        return mod2;
    }
}
