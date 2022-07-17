package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.User;

import java.util.Random;

import static hexlet.code.Engine.*;

public class Progression {
    private static final int COUNT_ELEMENTS = 10;

    private static int askQuestion() {
        Random rand = new Random();
        int countElements = COUNT_ELEMENTS;
        int firstElement = rand.nextInt(MAX_VALUE);
        int step = rand.nextInt(COUNT_ELEMENTS) + 1;
        int hiddenIndex = rand.nextInt(countElements - 1);
        int[] progression = new int[countElements];

        progression[0] = firstElement;
        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + step;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                stringBuilder.append("..");
            } else {
                stringBuilder.append(progression[i]);
            }
            stringBuilder.append(" ");
        }
        printQuestion(stringBuilder.toString());
        return progression[hiddenIndex];
    }

    public static void execute() {
        int successAnswers = 0;
        User user = new User(Cli.getGreeting());
        System.out.println("What number is missing in the progression?");

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
