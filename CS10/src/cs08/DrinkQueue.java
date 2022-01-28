package cs08;

import java.util.LinkedList;
import java.util.Queue;

public class DrinkQueue {

    private final Queue<Drink> drinks = new LinkedList<>();

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public Drink getDrinkOrder() {
        return drinks.poll();
    }
    public Drink peekOrder() {
        return drinks.peek();
    }

    public Queue<Drink> getQueue() {
        return drinks;
    }
}