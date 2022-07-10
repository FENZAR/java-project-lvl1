package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime extends Engine {

    private static final int MIN_PRIME_NUMBER = 2;
    public static void execute() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int successAnswers = 0;
        int randInt;
        boolean isPrime = false;
        getGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (successAnswers < WIN_COUNT) {
            randInt = rand.nextInt(MAX_VALUE - MIN_PRIME_NUMBER) + MIN_PRIME_NUMBER;
            int halfOfRandValue = randInt / 2;
            for (int i = MIN_PRIME_NUMBER; i < halfOfRandValue; i++) {
                if (randInt % i == 0) {
                    isPrime = false;
                    break;
                } else if (i == halfOfRandValue - 1) {
                    isPrime = true;
                }
            }
            System.out.println("Question: " + randInt);
            System.out.print("Your answer: ");
            String answer = sc.nextLine().toLowerCase();
            boolean isNegativeAnswer = NO.equals(answer);
            boolean isPositiveAnswer = YES.equals(answer);

            if (!isNegativeAnswer && !isPositiveAnswer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Expected answer was 'yes' or 'no'.");
                break;
            }

            if (isPrime) {
                if (isNegativeAnswer) {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    break;
                }
            } else {
                if (isPositiveAnswer) {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    break;
                }
            }
            System.out.println("Correct!");
            successAnswers++;
        }
        printResultMessage(successAnswers);
    }
}
