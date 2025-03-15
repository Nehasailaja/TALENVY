import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Random r = new Random();
        Scanner s = new Scanner(System.in);

        int total_rounds = 0;
        int total_score = 0;
        int rounds_won = 0;

        System.out.println("\n\n************WELCOME TO NUMBER GUSSESING GAME************\n");
        System.out.println("Selects a random number between 1-100 that matches mine!!!");

        boolean playAgain = true;

        while (playAgain) {
            int com_guess = r.nextInt(1, 101);
            int max_attempt = 10;
            int attempt = 0;
            int round_score = 100;
            boolean guessedCorrectly = false;

            System.out.println("You have " + max_attempt + " attempts to guess correct!!!");
            System.out.println("<<<<<< Your round is starting >>>>>>");
            System.out.println("--------------------------------------------------------------");

            while (attempt < max_attempt) {
                System.out.print("Please! Enter your guess:");
                int user_guess = s.nextInt();
                attempt++;

                if (user_guess == com_guess) {
                    System.out.println("Hurray!! your guess matches mine in " + attempt + " attempts");
                    System.out.println("Your score :" + round_score);
                    guessedCorrectly = true;
                    rounds_won++;
                    total_score += round_score;
                    break;
                } else if (user_guess > com_guess) {
                    System.out.println("Too high!! Try again!!");
                } else {
                    System.out.println("Too low!! Try again!!");
                }
                round_score -= 10;
            }
            if (!guessedCorrectly) {
                System.out.println("Game OVER!!! The correct number was: " + com_guess);
                System.out.println("Your score: " + round_score);
            }
            total_rounds++;
            System.out.print("\nDo you want to play again?? (YES/NO): ");
            String response = s.next().toUpperCase();
            playAgain = response.equals("YES");
        }

        int maxPossibleScore = total_rounds * 100;
        System.out.println("\n------ Final Results ------");
        System.out.println("Total rounds played: " + total_rounds);
        System.out.println("Total rounds won: " + rounds_won);
        System.out.println("Your final score: " + total_score + "/" + maxPossibleScore);
        System.out.println("Thanks for playing!!! Hope you have great time!!!");

        s.close();
    }
}
