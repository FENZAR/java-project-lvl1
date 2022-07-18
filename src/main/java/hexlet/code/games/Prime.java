package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.User;

import java.util.Random;

import static hexlet.code.Engine.MAX_VALUE;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.YES;
import static hexlet.code.Engine.NO;
import static hexlet.code.Engine.printQuestion;
import static hexlet.code.Engine.getAnswer;
import static hexlet.code.Engine.increaseCount;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;

public class Prime {

    private static final int MIN_PRIME_NUMBER = 2;

    private static boolean askQuestion() {
        Random rand = new Random();
        int randInt = rand.nextInt(MAX_VALUE - MIN_PRIME_NUMBER) + MIN_PRIME_NUMBER;
        int halfOfRandValue = randInt / 2;
        boolean isPrime = false;
        for (int i = MIN_PRIME_NUMBER; i < halfOfRandValue; i++) {
            if (randInt % i == 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
        printQuestion(Integer.toString(randInt));
        return isPrime;
    }

    public static void execute() {
        int successAnswers = 0;

        User user = new User(Cli.getGreeting());
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (successAnswers < WIN_COUNT) {
            boolean isPrime = askQuestion();
            String actualAnswer = getAnswer();
            String expectedResult = isPrime ? YES : NO;

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
