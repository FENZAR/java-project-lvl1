package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;

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
        System.out.println("0 - Exit");
        int choice = sc.nextInt();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1 -> getGreeting();
            case 2 -> Even.executeEvenGame();
            case 3 -> Calc.executeCalcGame();
            case 4 -> Gcd.executeGcdGame();
            default -> System.out.println("Exit");
        }
    }
}
