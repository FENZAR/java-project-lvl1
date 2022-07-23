package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.RESULT_INDEX;
import static hexlet.code.Engine.TWO;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.getRandValue;

public class Progression {
    private static final int COUNT_ELEMENTS = 10;
    private static final String PROGRESSION_RULES = "What is the result of the expression?";

    public static void startGame() {
        String[][] questions = new String[WIN_COUNT][TWO];
        for (int i = 0; i < WIN_COUNT; i++) {
            int hiddenIndex = getRandValue(COUNT_ELEMENTS - 1);
            int[] progression = getProgression();
            questions[i][QUESTION_INDEX] = getProgressionQuestion(progression, hiddenIndex);
            questions[i][RESULT_INDEX] = Integer.toString(progression[hiddenIndex]);
        }
        Engine.execute(PROGRESSION_RULES, questions);
    }

    private static int[] getProgression() {
        int[] progression = new int[COUNT_ELEMENTS];
        int firstElement = getRandValue();
        int step = getRandValue(COUNT_ELEMENTS) + 1;
        progression[0] = firstElement;
        for (int j = 1; j < progression.length; j++) {
            progression[j] = progression[j - 1] + step;
        }
        return progression;
    }

    private static String getProgressionQuestion(int[] progression, int hiddenIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < progression.length; j++) {
            if (j == hiddenIndex) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[j]);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
