package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc extends Engine {
    private static final int MAX_VALUE = 1001;
    public static void executeCalcGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int successAnswers = 0;
        String userName = getGreeting();
        String letsTryAgainName = "Let's try again, " + userName + "!";
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        while (successAnswers < WIN_COUNT) {
            int randInt = rand.nextInt(MAX_VALUE);

        }
    }
}
