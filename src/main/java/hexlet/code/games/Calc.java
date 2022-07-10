package hexlet.code.games;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Engine.getGreeting;
import static hexlet.code.Engine.getIntAnswer;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.MAX_VALUE;

public class Calc {

    public static void execute() {
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
