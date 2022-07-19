package hexlet.code;

import static hexlet.code.EngineHelper.WIN_COUNT;
import static hexlet.code.EngineHelper.getAnswer;
import static hexlet.code.EngineHelper.printQuestion;
import static hexlet.code.EngineHelper.printResultMessage;
import static hexlet.code.EngineHelper.printWrongAnswer;

public class Engine {
    private final String[] questions;
    private final String[] expectedResults;
    private final String gameRules;

    public Engine(String rules, String[] gameQuestions, String[] results) {
        this.gameRules = rules;
        this.questions = gameQuestions;
        this.expectedResults = results;
    }

    /**
     * Execute game instance.
     */
    public void execute() {
        int successAnswers = 0;
        User user = new User(Cli.getGreeting());
        System.out.println(gameRules);

        for (int i = 0; i < WIN_COUNT; i++) {
            printQuestion(questions[i]);
            String actualAnswer = getAnswer();

            if (expectedResults[i].equals(actualAnswer)) {
                System.out.println("Correct!");
                successAnswers++;
            } else {
                printWrongAnswer(actualAnswer, expectedResults[i]);
                break;
            }
        }
        printResultMessage(successAnswers, user);
    }
}
