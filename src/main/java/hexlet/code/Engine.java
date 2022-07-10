package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int WIN_COUNT = 3;
    public static final int MAX_VALUE = 100;
    public static final String YES = "yes";
    public static final String NO = "no";

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

    public static void printResultMessage(int successAnswers) {
        System.out.println(successAnswers == WIN_COUNT ? getCongratulations() : getLetsTryAgainMessage());
    }

    public static void printWrongAnswer(String actual, String result) {
        System.out.println(actual + " is wrong answer ;(. Correct answer was " + result);
    }

    public static int getIntAnswer(int expected) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            printWrongAnswer(sc.next(), Integer.toString(expected));
            return Integer.MIN_VALUE;
        }
        return sc.nextInt();
    }

    public static void getGreeting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = sc.nextLine();
        System.out.println("Hello, " + name  + "!\n");
        setUserName(name);
    }
}
