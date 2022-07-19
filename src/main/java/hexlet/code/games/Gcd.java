package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.EngineHelper.MAX_VALUE;
import static hexlet.code.EngineHelper.WIN_COUNT;

public class Gcd {
    public static void startGame() {
        Random rand = new Random();
        String[] results = new String[WIN_COUNT];
        String[] questions = new String[WIN_COUNT];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt1 = rand.nextInt(MAX_VALUE);
            int randInt2 = rand.nextInt(MAX_VALUE);
            int min = Math.min(randInt1, randInt2);
            int max = Math.max(randInt1, randInt2);
            questions[i] = randInt1 + " " + randInt2;
            results[i] = Integer.toString(getGcd(min, max));
        }
        String rules = "Find the greatest common divisor of given numbers.";
        Engine engine = new Engine(rules, questions, results);
        engine.execute();
    }

    private static int getGcd(int mod2, int mod1) {
        try {
            int mod = mod1 % mod2;
            if (mod != 0) {
                while (mod > 0) {
                    mod1 = mod2;
                    mod2 = mod;
                    mod = mod1 % mod2;
                }
            }
        } catch (ArithmeticException e) {
            return 0;
        }
        return mod2;
    }
}
