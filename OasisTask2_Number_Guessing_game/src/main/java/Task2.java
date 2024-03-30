import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_ROUNDS = 3;

    public static  void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("You have %d rounds to play.\n", MAX_ROUNDS);
        System.out.printf("You have %d attempts to guess the number in each round.\n\n", MAX_ATTEMPTS);

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            System.out.println("---------------------------------------------------------------");
            System.out.printf("Round %d\n", round);
            System.out.println("---------------------------------------------------------------");

            boolean guessedCorrectly = false;
            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                System.out.printf("Attempt %d: Enter your guess between %d and %d: ", attempt, MIN_RANGE, MAX_RANGE);
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("*******************************************************************");
                    System.out.println("Congratulations! You guessed the number!");
                    int score = MAX_ATTEMPTS - attempt + 1; // Score calculation
                    totalScore += score;
                    System.out.printf("Your score for this round: %d\n", score);
                    System.out.println("*******************************************************************");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("The number is higher.");
                } else {
                    System.out.println("The number is lower.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("*******************************************************************");
                System.out.printf("Sorry! You couldn't guess the number. The correct number was: %d\n", numberToGuess);
                System.out.println("*******************************************************************");
            }

            System.out.println(); // Add a newline for clarity
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Game over. Your total score: %d\n", totalScore);
        System.out.println("---------------------------------------------------------------");
        scanner.close();
    }
}
