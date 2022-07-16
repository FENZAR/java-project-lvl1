package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.User;

import java.util.Random;

import static hexlet.code.Engine.getIntAnswer;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.MAX_VALUE;

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

    public static void execute() {
        Random rand = new Random();
        int successAnswers = 0;
        int randInt1;
        int randInt2;
        int min;
        int max;
        int result;
        User user = new User(Cli.getGreeting());
        System.out.println("Find the greatest common divisor of given numbers.");

        while (successAnswers < WIN_COUNT) {
            randInt1 = rand.nextInt(MAX_VALUE);
            randInt2 = rand.nextInt(MAX_VALUE);

            min = Math.min(randInt1, randInt2);
            max = Math.max(randInt1, randInt2);

            result = getGcd(min, max);

            System.out.println("Question: " + randInt1 + " " + randInt2);
            System.out.print("Your answer: ");
            int answer = getIntAnswer(result);
            if (result == answer) {
                successAnswers++;
                System.out.println("Correct!");
            } else {
                printWrongAnswer(Integer.toString(answer), Integer.toString(result));
                break;
            }
        }
        printResultMessage(successAnswers, user);
    }
}
