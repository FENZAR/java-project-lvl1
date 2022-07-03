package hexlet.code;

import java.util.Scanner;

public class Engine {
    protected static final int WIN_COUNT = 3;

    private static String userName;

    private static void setUserName(String name) {
        userName = name;
    }

    public static String getLetsTryAgainMessage() {
        return "Let's try again, " + userName + "!";
    }

    public static String getCongratulations() {
        return "Congratulations, " + userName + "!";
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
