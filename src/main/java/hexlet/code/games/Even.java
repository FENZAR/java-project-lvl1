package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.User;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Engine.*;

public class Even {

    private static boolean askQuestion() {
        Random rand = new Random();
        int randInt = rand.nextInt(MAX_VALUE);
        printQuestion(Integer.toString(randInt));
        return randInt % 2 == 0;
    }

    public static void execute() {
        int successAnswers = 0;
        User user = new User(Cli.getGreeting());
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        while (successAnswers < WIN_COUNT) {
            boolean isEven = askQuestion();
            String actualAnswer = getAnswer();
            String expectedResult = isEven ? YES : NO;

            if (expectedResult.equalsIgnoreCase(actualAnswer)) {
                successAnswers += increaseCount();
            } else {
                printWrongAnswer(actualAnswer, expectedResult);
                break;
            }
        }
        printResultMessage(successAnswers, user);
    }
}
