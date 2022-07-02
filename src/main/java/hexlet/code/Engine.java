package hexlet.code;

import java.util.Scanner;

public abstract class Engine {
    protected static final int WIN_COUNT = 3;

    protected static String getGreeting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = sc.nextLine();
        System.out.println("Hello, " + name  + "!\n");
        return name;
    }
}
