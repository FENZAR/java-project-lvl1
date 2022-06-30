package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        int choice = sc.nextInt();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1 -> Cli.getGreeting();
            case 2 -> Even.executeEvenGame();
            default -> System.out.println("Exit");
        }
    }
}
