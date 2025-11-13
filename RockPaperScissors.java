// RockPaperScissors.java — Handles gameplay with automatic messages and history
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends GameBase {
    private Scoreboard scoreboard = new Scoreboard();
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    public void startGame() {
        while (true) {
            System.out.println("======================================");
            System.out.println("---- Rock Paper Scissors Game ----");
            System.out.println("======================================");
            System.out.println("1. Play Game");
            System.out.println("2. History");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": play(); break;
                case "2": viewPlayerHistoryById(); break;
                case "3":
                    System.out.println("Goodbye! Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    private void viewPlayerHistoryById() {
        System.out.print("\nEnter your Player ID (e.g., B00): ");
        String playerId = sc.nextLine().trim();
        scoreboard.searchPlayerHistory(playerId);
    }

    private void play() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Player player = new Player(name);

        int rounds = 0;

while (true) {
    System.out.print("How many rounds do you want to play? ");
    String input = sc.nextLine();
    try {
        rounds = Integer.parseInt(input);
        if (rounds <= 0) {
            System.out.println("Please enter a positive number.");
            continue;
        }
        break; // valid input, exit loop
    } catch (NumberFormatException e) {
        System.out.println("Invalid number! Please enter a valid number.\n");
    }
}

        System.out.println("\nWelcome, " + player.getName() + "! Your Player ID is " + player.getId());
        System.out.println("Type 'exit' anytime to stop the game.\n");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("ROUND " + round);
            System.out.print("Choose [Rock / Paper / Scissors / exit]: ");
            String playerChoice = sc.nextLine().trim();

            if (playerChoice.equalsIgnoreCase("exit")) {
                System.out.println("You exited early. Returning to main menu.\n");
                break;
            }

            if (!playerChoice.equalsIgnoreCase("Rock") &&
                !playerChoice.equalsIgnoreCase("Paper") &&
                !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.\n");
                round--; 
                continue;
            }

            String compChoice = computerChoice();
            System.out.println("Cuties choice: " + compChoice);

            String result = checkWinner(playerChoice, compChoice);
            scoreboard.recordResult(result);

            // Random automatic messages
            switch (result) {
                case "Player":
                    player.addScore();
                    String[] winMsgs = {
                        "Nice one! You won this round!",
                        "That was nice! You won this time!",
                        "That was smooth~~~ you beat the cutie coders!",
                        "VICTORYYYYY!",
                        "You're on fire! Well played!"
                    };
                    System.out.println(winMsgs[random.nextInt(winMsgs.length)]);
                    break;

                case "CUTIES":
                    String[] loseMsgs = {
                        "OH! Better luck next time!",
                        "Better luck next round!",
                        "The cuties strikes back!",
                        "You lost this round, but keep going!",
                        "Don’t give up, KEEP IT UP UNTIL YOU'RE BRILLANT AS ME:)"
                    };
                    System.out.println(loseMsgs[random.nextInt(loseMsgs.length)]);
                    break;

                case "Draw":
                    String[] drawMsgs = {
                        "It’s a tie! Great minds think alike.",
                        "Draw! Nobody wins this time.",
                        "Same choice like TWINS!",
                        "Well, thats a fair match!",
                        "Tie game! Go for it!"
                    };
                    System.out.println(drawMsgs[random.nextInt(drawMsgs.length)]);
                    break;
            }

            System.out.println("Current Score: " + player.getScore() + "/" + round + "\n");
        }

        System.out.println("Game Over, " + player.getName() + "! Final Score: " + player.getScore() + "/" + rounds);
        scoreboard.recordPlayerHistory(player, rounds);
    }
}
