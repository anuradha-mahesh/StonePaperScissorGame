import java.util.Scanner;
import java.util.Random;

public class StonePaperScissors {

    public static void main(String[] args) {
        String[] choices = {"Stone", "Paper", "Scissors"};
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        System.out.println("Welcome to Stone-Paper-Scissors Game!");

        while (true) {
            System.out.print("\nEnter your choice (0=Stone, 1=Paper, 2=Scissors): ");
            int userChoice = sc.nextInt();

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid Choice! Please try again...");
                continue;
            }

            int compChoice = rand.nextInt(3);

            System.out.println("You chose: " + choices[userChoice]);
            System.out.println("Computer chose: " + choices[compChoice]);

            // Determine winner
            if (userChoice == compChoice) {
                System.out.println("It's a tie!");
                ties++;
            } else if ((userChoice == 0 && compChoice == 2) ||
                       (userChoice == 1 && compChoice == 0) ||
                       (userChoice == 2 && compChoice == 1)) {
                System.out.println("You won!");
                userWins++;
            } else {
                System.out.println("Computer won!");
                compWins++;
            }

            // Show current score
            System.out.println("\nScore:");
            System.out.println("You: " + userWins + " | Computer: " + compWins + " | Ties: " + ties);

            // Ask if user wants to play again
            System.out.print("\nDo you want to play again (Yes/No)? ");
            String retry = sc.next().trim();
            if (retry.equalsIgnoreCase("no")) {
                System.out.println("\nThanks for playing! \n \nFinal Score:");
                System.out.println("You: " + userWins + " | Computer: " + compWins + " | Ties: " + ties);
                break;
            }
        }

        sc.close();
    }
}
