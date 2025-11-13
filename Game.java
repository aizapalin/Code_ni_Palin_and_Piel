// Game.java — Main controller
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors();

        game.startGame(); // main game loop
        scanner.close();
    }
}

