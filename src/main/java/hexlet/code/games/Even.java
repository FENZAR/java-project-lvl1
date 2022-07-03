package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even extends Engine {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int MAX_VALUE = 1001;

    public static void executeEvenGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int successAnswers = 0;
        getGreeting();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");

        while (successAnswers < WIN_COUNT) {
            int randInt = rand.nextInt(MAX_VALUE);
            boolean isEven = randInt % 2 == 0;
            System.out.println("Question: " + randInt);
            System.out.print("Your answer: ");
            String answer = sc.nextLine().toLowerCase();
            boolean isNegativeAnswer = NO.equals(answer);
            boolean isPositiveAnswer = YES.equals(answer);

            if (!isNegativeAnswer && !isPositiveAnswer) {
                System.out.println("'" + answer + "' is wrong answer ;(. Expected answer was 'yes' or 'no'.");
                break;
            }

            if (isEven) {
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

        System.out.println(successAnswers == WIN_COUNT ? getCongratulations() : getLetsTryAgainMessage());
    }
}
