package hexlet.code.games;

import hexlet.code.User;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;

import static hexlet.code.Cli.getGreeting;
import static hexlet.code.Engine.MAX_VALUE;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.getIntAnswer;
import static hexlet.code.Engine.printQuestion;
import static hexlet.code.Engine.increaseCount;
import static hexlet.code.Engine.printWrongAnswer;
import static hexlet.code.Engine.printResultMessage;

public class Calc {

    private static int askQuestion() {
        Random rand = new Random();
        char[] operator = {'+', '-', '*'};
        int randInt1 = rand.nextInt(MAX_VALUE);
        int randInt2 = rand.nextInt(MAX_VALUE);
        int operatorIndex = rand.nextInt(operator.length);
        String stringExpression = "" + randInt1 + " " + operator[operatorIndex]  + " " + randInt2;
        Expression expression = new ExpressionBuilder(stringExpression).build();
        printQuestion(stringExpression);
        return (int) expression.evaluate();
    }

    public static void execute() {
        int successAnswers = 0;
        User user = new User(getGreeting());
        System.out.println("What is the result of the expression?");

        while (successAnswers < WIN_COUNT) {
            int expectedResult = askQuestion();

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
