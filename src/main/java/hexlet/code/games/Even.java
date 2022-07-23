package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.RESULT_INDEX;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.TWO;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.YES;
import static hexlet.code.Engine.NO;
import static hexlet.code.Engine.YES_NO_RULES;
import static hexlet.code.Engine.getRandValue;

public class Even {
    private static final String EVEN = "even";
    public static void startGame() {
        String[][] questions = new String[WIN_COUNT][TWO];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt = getRandValue();
            questions[i][QUESTION_INDEX] = Integer.toString(randInt);
            questions[i][RESULT_INDEX] = randInt % 2 == 0 ? YES : NO;
        }
        Engine.execute(String.format(YES_NO_RULES, EVEN), questions);
    }
}
