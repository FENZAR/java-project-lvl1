package hexlet.code.games;

import hexlet.code.Engine;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;

import static hexlet.code.EngineHelper.MAX_VALUE;
import static hexlet.code.EngineHelper.WIN_COUNT;

public class Calc {
    public static void startGame() {
        Random rand = new Random();
        String[] results = new String[WIN_COUNT];
        String[] questions = new String[WIN_COUNT];
        final char[] operator = {'+', '-', '*'};
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt1 = rand.nextInt(MAX_VALUE);
            int randInt2 = rand.nextInt(MAX_VALUE);
            int operatorIndex = rand.nextInt(operator.length);
            String stringExpression = "" + randInt1 + " " + operator[operatorIndex]  + " " + randInt2;
            Expression expression = new ExpressionBuilder(stringExpression).build();
            questions[i] = stringExpression;
            results[i] = Integer.toString((int) expression.evaluate());
        }
        String rules = "What is the result of the expression?";
        Engine engine = new Engine(rules, questions, results);
        engine.execute();
    }
}
