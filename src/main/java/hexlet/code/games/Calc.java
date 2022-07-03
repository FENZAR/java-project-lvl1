package hexlet.code.games;

import hexlet.code.Engine;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;
import java.util.Scanner;

public class Calc extends Engine {

    private static final int MAX_VALUE = 101;

    public static void executeCalcGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int successAnswers = 0;
        int randInt1;
        int randInt2;
        int operatorIndex;
        char[] operator = {'+', '-', '*'};
        getGreeting();

        System.out.println("What is the result of the expression?");

        while (successAnswers < WIN_COUNT) {
            randInt1 = rand.nextInt(MAX_VALUE);
            randInt2 = rand.nextInt(MAX_VALUE);
            operatorIndex = rand.nextInt(operator.length);
            String stringExpression = "" + randInt1 + operator[operatorIndex] + randInt2;
            System.out.println("Question: " + stringExpression);
            Expression expression = new ExpressionBuilder(stringExpression).build();
            int result = (int) expression.evaluate();

            System.out.print("Your answer: ");
            int answer = 0;
            if (sc.hasNextInt()) {
                answer = sc.nextInt();
            } else {
                System.out.println(sc.next() + " is wrong answer ;(. Correct answer was " + result);
                break;
            }

            if (result == answer) {
                successAnswers++;
                System.out.println("Correct!");
            } else {
                System.out.println("" + answer + " is wrong answer ;(. Correct answer was " + result);
                break;
            }
        }

        System.out.println(successAnswers == WIN_COUNT ? getCongratulations() : getLetsTryAgainMessage());
    }
}
