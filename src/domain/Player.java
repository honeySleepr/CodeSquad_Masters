package domain;

public class Player implements GameComponents {
    private final String name;
    private final int startIndex;
    private String prize;

    public Player(String name, int startIndex) {
        this.name = name;
        this.startIndex = startIndex;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
