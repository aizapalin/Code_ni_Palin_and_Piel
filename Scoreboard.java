// Scoreboard.java — Tracks results and player history with scoreboard stats
import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private int totalWins;
    private int totalLosses;
    private int totalDraws;

    private List<String> playerHistory = new ArrayList<>();

    public void recordResult(String result) {
        switch (result) {
            case "Player": totalWins++; break;
            case "Cuties": totalLosses++; break;
            case "Draw": totalDraws++; break;
        }
    }

    // Record player history including scoreboard stats
    public void recordPlayerHistory(Player player, int rounds) {
        String entry = String.format(
            "ID: %s | Name: %s | Score: %d/%d | Total Wins: %d | Total Losses: %d | Total Draws: %d",
            player.getId(),
            player.getName(),
            player.getScore(),
            rounds,
            totalWins,
            totalLosses,
            totalDraws
        );
        playerHistory.add(entry);
    }

    // Search player history by ID
    public void searchPlayerHistory(String playerId) {
        boolean found = false;
        System.out.println("\nHistory \"" + playerId + "\":");
        for (String entry : playerHistory) {
            if (entry.toLowerCase().contains(playerId.toLowerCase())) {
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No history found for that Player ID.\n");
        } else {
            System.out.println();
        }
    }
}
