package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

import static hexlet.code.Engine.getGreeting;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        var choice = sc.next();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case "1" -> getGreeting();
            case "2" -> Even.execute();
            case "3" -> Calc.execute();
            case "4" -> Gcd.execute();
            case "5" -> Progression.execute();
            default -> System.out.println("Exit");
        }
    }
}
