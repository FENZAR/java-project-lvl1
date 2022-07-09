package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Gcd extends Engine {

    public static void execute() {
        Random rand = new Random();
        int successAnswers = 0;
        int randInt1;
        int randInt2;
        int min;
        int max;
        int mod1;
        int mod2;
        int result;
        getGreeting();
        System.out.println("Find the greatest common divisor of given numbers.");

        while (successAnswers < WIN_COUNT) {
            randInt1 = rand.nextInt(MAX_VALUE);
            randInt2 = rand.nextInt(MAX_VALUE);

            min = Math.min(randInt1, randInt2);
            max = Math.max(randInt1, randInt2);

            mod1 = max % min;
            if (mod1 == 0) {
                result = min;
            } else {
                mod2 = mod1;
                mod1 = min;
                int mod = mod1 % mod2;
                while (mod > 0) {
                    mod1 = mod2;
                    mod2 = mod;
                    mod = mod1 % mod2;
                }
                result = mod2;
            }

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
        printResultMessage(successAnswers);
    }
}
