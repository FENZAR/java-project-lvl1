package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.User;

import java.util.Random;

import static hexlet.code.Engine.MAX_VALUE;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.getIntAnswer;
import static hexlet.code.Engine.printQuestion;
import static hexlet.code.Engine.increaseCount;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;

public class Gcd {

    private static int getGcd(int mod2, int mod1) {
        int mod = mod1 % mod2;
        if (mod != 0) {
            while (mod > 0) {
                mod1 = mod2;
                mod2 = mod;
                mod = mod1 % mod2;
            }
        }
        return mod2;
    }

    private static int askQuestion() {
        Random rand = new Random();
        int randInt1 = rand.nextInt(MAX_VALUE);
        int randInt2 = rand.nextInt(MAX_VALUE);
        int min = Math.min(randInt1, randInt2);
        int max = Math.max(randInt1, randInt2);
        printQuestion(randInt1 + " " + randInt2);
        return getGcd(min, max);
    }

    public static void execute() {
        int successAnswers = 0;
        User user = new User(Cli.getGreeting());
        System.out.println("Find the greatest common divisor of given numbers.");

        while (successAnswers < WIN_COUNT) {
            int expectedResult = askQuestion();

            System.out.print("Your answer: ");
            int actualAnswer = getIntAnswer(expectedResult);
            if (expectedResult == actualAnswer) {
                successAnswers += increaseCount();
            } else {
                printWrongAnswer(Integer.toString(actualAnswer), Integer.toString(expectedResult));
                break;
            }
        }
        printResultMessage(successAnswers, user);
    }
}
