package hexlet.code.games;

import hexlet.code.Engine;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.RESULT_INDEX;
import static hexlet.code.Engine.TWO;
import static hexlet.code.Engine.WIN_COUNT;
import static hexlet.code.Engine.getRandValue;

public class Calc {
    private static final String CALC_RULES = "What is the result of the expression?";
    private static final String EXPRESSION_TEMPLATE = "%d + %s + %d";

    public static void startGame() {
        final char[] operator = {'+', '-', '*'};
        String[][] questions = new String[WIN_COUNT][TWO];
        for (int i = 0; i < WIN_COUNT; i++) {
            int randInt1 = getRandValue();
            int randInt2 = getRandValue();
            int operatorIndex = getRandValue(operator.length);
            String stringExpression = String.format(EXPRESSION_TEMPLATE, randInt1, operator[operatorIndex], randInt2);
            Expression expression = new ExpressionBuilder(stringExpression).build();
            questions[i][QUESTION_INDEX] = stringExpression;
            questions[i][RESULT_INDEX] = Integer.toString((int) expression.evaluate());
        }
        Engine.execute(CALC_RULES, questions);
    }
}
