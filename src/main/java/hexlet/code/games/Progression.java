package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.EngineHelper.MAX_VALUE;
import static hexlet.code.EngineHelper.WIN_COUNT;

public class Progression {
    private static final int COUNT_ELEMENTS = 10;

    public static void startGame() {
        Random rand = new Random();
        String[] results = new String[WIN_COUNT];
        String[] questions = new String[WIN_COUNT];

        for (int i = 0; i < WIN_COUNT; i++) {
            int[] progression = new int[COUNT_ELEMENTS];
            int firstElement = rand.nextInt(MAX_VALUE);
            int step = rand.nextInt(COUNT_ELEMENTS) + 1;
            int hiddenIndex = rand.nextInt(COUNT_ELEMENTS - 1);

            progression[0] = firstElement;
            for (int j = 1; j < progression.length; j++) {
                progression[j] = progression[j - 1] + step;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < progression.length; j++) {
                if (j == hiddenIndex) {
                    stringBuilder.append("..");
                } else {
                    stringBuilder.append(progression[j]);
                }
                stringBuilder.append(" ");
            }

            questions[i] = stringBuilder.toString();
            results[i] = Integer.toString(progression[hiddenIndex]);
        }
        String rules = "What is the result of the expression?";
        Engine engine = new Engine(rules, questions, results);
        engine.execute();
    }
}
