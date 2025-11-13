// GameBase.java — Core logic superclass
import java.util.Random;

public class GameBase {
    protected String[] choices = {"Rock", "Paper", "Scissors"};
    protected Random random = new Random();

    public String computerChoice() {
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    public String checkWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        } else if (
            (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
            (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
            (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))
        ) {
            return "Player";
        } else {
            return "Computer";
        }
    }
}
