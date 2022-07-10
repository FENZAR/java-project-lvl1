package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.getGreeting;
import static hexlet.code.Engine.getIntAnswer;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.MAX_VALUE;
public class Progression {
    private static final int COUNT_ELEMENTS = 10;

    public static void execute() {
        Random rand = new Random();
        int successAnswers = 0;
        int countElements = COUNT_ELEMENTS;
        int firstElement;
        int step;
        int hiddenIndex;
        int hiddenElement;
        getGreeting();
        System.out.println("What number is missing in the progression?");

        while (successAnswers < WIN_COUNT) {
            firstElement = rand.nextInt(MAX_VALUE);
            step = rand.nextInt(COUNT_ELEMENTS) + 1;
            int[] progression = new int[countElements];
            hiddenIndex = rand.nextInt(countElements - 1);
            progression[0] = firstElement;
            for (int i = 1; i < progression.length; i++) {
                progression[i] = progression[i - 1] + step;
            }
            hiddenElement = progression[hiddenIndex];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < progression.length; i++) {
                if (i == hiddenIndex) {
                    stringBuilder.append("..");
                } else {
                    stringBuilder.append(progression[i]);
                }
                stringBuilder.append(" ");
            }
            System.out.println("Question: " + stringBuilder);
            System.out.print("Your answer: ");
            int answer = getIntAnswer(hiddenElement);
            if (hiddenElement == answer) {
                successAnswers++;
                System.out.println("Correct!");
            } else {
                printWrongAnswer(Integer.toString(answer), Integer.toString(hiddenElement));
                break;
            }
        }
        printResultMessage(successAnswers);
    }
}
