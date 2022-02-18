package domain;

public class Prize implements GameComponents{
    private final String prizeName;
    private final int prizeIndex;

    public Prize(String prizeName, int prizeIndex) {
        this.prizeName = prizeName;
        this.prizeIndex = prizeIndex;
    }

    @Override
    public String getName() {
        return this.prizeName;
    }
}
