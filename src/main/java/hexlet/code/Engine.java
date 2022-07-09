package hexlet.code;

import java.util.Scanner;

public class Engine {
    protected static final int WIN_COUNT = 3;
    protected static final int MAX_VALUE = 100;

    private static String userName;

    private static void setUserName(String name) {
        userName = name;
    }

    private static String getLetsTryAgainMessage() {
        return "Let's try again, " + userName + "!";
    }

    private static String getCongratulations() {
        return "Congratulations, " + userName + "!";
    }

    protected static void printResultMessage(int successAnswers) {
        System.out.println(successAnswers == WIN_COUNT ? getCongratulations() : getLetsTryAgainMessage());
    }

    protected static void printWrongAnswer(String actual, String result) {
        System.out.println(actual + " is wrong answer ;(. Correct answer was " + result);
    }

    protected static int getIntAnswer(int expected) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            printWrongAnswer(sc.next(), Integer.toString(expected));
            return Integer.MIN_VALUE;
        }
        return sc.nextInt();
    }

    protected static void getGreeting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = sc.nextLine();
        System.out.println("Hello, " + name  + "!\n");
        setUserName(name);
    }
}
