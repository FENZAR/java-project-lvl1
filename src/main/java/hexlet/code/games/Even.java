package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.EngineHelper.MAX_VALUE;
import static hexlet.code.EngineHelper.WIN_COUNT;
import static hexlet.code.EngineHelper.YES;
import static hexlet.code.EngineHelper.NO;

public class Even {
    public static void startGame() {
        Random rand = new Random();
        String[] results = new String[WIN_COUNT];
        String[] questions = new String[WIN_COUNT];


        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt = rand.nextInt(MAX_VALUE);
            questions[i] = Integer.toString(randInt);
            results[i] = randInt % 2 == 0 ? YES : NO;
        }
        String rules = "Answer 'yes' if number even otherwise answer 'no'.";
        Engine engine = new Engine(rules, questions, results);
        engine.execute();
    }
}
