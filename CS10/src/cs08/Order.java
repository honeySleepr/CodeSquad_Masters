package cs08;

public class Order {

    private final String drink;
    private final int count;

    public Order(String drink, int count) {
        this.drink = drink;
        this.count = count;
    }

    public String getDrink() {
        return this.drink;
    }

    public int getCount() {
        return this.count;
    }
}