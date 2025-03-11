import java.util.Scanner;
import java.util.Random;

public class codsoft_taskno1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomizer = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int secretNumber = randomizer.nextInt(100) + 1;
            int attemptsLeft = 7;

            System.out.println("\nGuess the number between 1 and 100. You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = input.nextInt();
                attemptsLeft--;

                if (userGuess == secretNumber) {
                    System.out.println("Correct! You guessed the number in " + (7 - attemptsLeft) + " attempts.");
                    score++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attemptsLeft == 0) {
                    System.out.println("Out of attempts! The correct number was " + secretNumber + ".");
                }
            }

            System.out.println("\nYour score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = input.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        input.close();
    }
}
