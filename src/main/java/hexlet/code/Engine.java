package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static final int QUESTION_INDEX = 0;
    public static final int RESULT_INDEX = 1;
    public static final int TWO = 2;
    public static final int WIN_COUNT = 3;
    public static final int MAX_VALUE = 100;
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String YES_NO_RULES = "Answer 'yes' if number %s otherwise answer 'no'.";

    private static final String CORRECT = "Correct!";
    private static final String WELCOME = "Welcome to the Brain Games!";
    private static final String HELLO = "Hello, %s!\n";
    private static final String WRONG_ANSWER = "%s is wrong answer ;(. Correct answer was %s";
    private static final String YOUR_NAME = "May I have your name?";
    private static final String YOUR_ANSWER = "Your answer: ";
    private static final String QUESTION = "Question: %s";
    private static final String TRY_AGAIN = "Let's try again, %s!";
    private static final String CONGRATULATIONS = "Congratulations, %s!";

    /**
     * Execute game instance.
     *
     * @param rules - description of the rules
     * @param questions - String array of questions with expected answers
     */
    public static void execute(String rules, final String[][] questions) {
        int successAnswers = 0;
        String userName = getUserName();
        printMessage(rules);

        for (int i = 0; i < WIN_COUNT; i++) {
            printQuestion(questions[i][QUESTION_INDEX]);
            String actualAnswer = getAnswer();
            String expectedResult = questions[i][RESULT_INDEX];

            if (expectedResult.equals(actualAnswer)) {
                printMessage(CORRECT);
                successAnswers++;
            } else {
                printWrongAnswer(actualAnswer, expectedResult);
                break;
            }
        }
        printResultMessage(successAnswers, userName);
    }

    public static int getRandValue() {
        return getRandValue(MAX_VALUE);
    }

    public static int getRandValue(int bound) {
        return new Random().nextInt(bound);
    }

    public static void printResultMessage(int successAnswers, String name) {
        printMessage(String.format((successAnswers == WIN_COUNT ? CONGRATULATIONS : TRY_AGAIN), name));
    }

    public static void printWrongAnswer(String actualResult, String expectedResult) {
        printMessage(String.format(WRONG_ANSWER, actualResult, expectedResult));
    }

    public static String getAnswer() {
        printMessage(YOUR_ANSWER);
        return readLine().toLowerCase().trim();
    }

    private static String getUserName() {
        printMessage(WELCOME);
        printMessage(YOUR_NAME);
        String name = readLine();
        printMessage(String.format(HELLO, name));
        return name;
    }

    private static String readLine() {
        return new Scanner(System.in).nextLine();
    }

    static void printQuestion(String question) {
        printMessage(String.format(QUESTION, question));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
