import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 5; // Change this value to set the limit of attempts
        int rounds = 3; // Change this value to set the number of rounds
        int totalScore = 0;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("You have " + numberOfAttempts + " attempts in each round.");

        for (int round = 1; round <= rounds; round++) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = numberOfAttempts;
            int roundScore = 0;

            System.out.println("\nRound " + round + ": Guess the number between " + lowerBound + " and " + upperBound);

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    roundScore = attemptsLeft * 10; // Give points based on attempts
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
            }

            totalScore += roundScore;
            System.out.println("Round " + round + " ended. Your score for this round: " + roundScore);
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
        scanner.close();
    }
}
