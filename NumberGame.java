import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int totalScore = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Guessing Game! ===");
        System.out.println("Rules: Guess the number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts per round.\n");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            while (attemptsUsed < maxAttempts) {
                System.out.print("Attempt " + (attemptsUsed + 1) + "/" + maxAttempts + " - Enter your guess: ");

                // Validate integer input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attemptsUsed++;

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    // Score calculation: more points for fewer attempts
                    int roundScore = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += roundScore;
                    roundsWon++;
                    System.out.println("Congratulations! You guessed the number in " + attemptsUsed + " attempts!");
                    System.out.println("Round Score: +" + roundScore + " points.");
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nOut of attempts! The correct number was: " + targetNumber);
            }
            // Display current stats
            System.out.println("\n--- Current Scoreboard ---");
            System.out.println("Rounds Won: " + roundsWon);
            System.out.println("Total Score: " + totalScore);
            System.out.println("--------------------------");

            // Ask to play again
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            System.out.println();
        }

        System.out.println("Thanks for playing! Final Score: " + totalScore + " | Total Rounds Won: " + roundsWon);
        scanner.close();
    }
}