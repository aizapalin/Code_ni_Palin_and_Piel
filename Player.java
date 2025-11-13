// Player.java — Stores player data
public class Player {
    private static int nextId = 1;
    private String id;
    private String name;
    private int score;

    public Player(String name) {
        this.id = String.format("B%02d", nextId++);
        this.name = name;
        this.score = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public void addScore() { score++; }
}
