package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.EngineHelper.MAX_VALUE;
import static hexlet.code.EngineHelper.WIN_COUNT;
import static hexlet.code.EngineHelper.YES;
import static hexlet.code.EngineHelper.NO;

public class Prime {
    private static final int MIN_PRIME_NUMBER = 2;

    public static void startGame() {
        Random rand = new Random();
        String[] results = new String[WIN_COUNT];
        String[] questions = new String[WIN_COUNT];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt = rand.nextInt(MAX_VALUE - MIN_PRIME_NUMBER) + MIN_PRIME_NUMBER;
            questions[i] = Integer.toString(randInt);
            results[i] = isPrime(randInt)  ? YES : NO;
        }
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine engine = new Engine(rules, questions, results);
        engine.execute();
    }

    private static boolean isPrime(int value) {
        int halfOfRandValue = value / 2;
        boolean isPrime = false;
        for (int i = MIN_PRIME_NUMBER; i < halfOfRandValue; i++) {
            if (value % i == 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
        return isPrime;
    }
}
