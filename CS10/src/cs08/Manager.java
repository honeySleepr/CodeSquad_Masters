package cs08;

import java.util.Optional;
import java.util.Queue;

public class Manager {
    private Barista barista;
    private DrinkQueue drinkQueue;

    public Manager(Barista barista, DrinkQueue drinkQueue) {
        this.barista = barista;
        this.drinkQueue = drinkQueue;
    }

    public void sendOrder() {
        while (true) {
            if (barista.isReady()) {
                Optional<Drink> drinkOrder = Optional.ofNullable(drinkQueue.getDrinkOrder());
                if (drinkOrder.isPresent()) {
                    barista.updateTodo(drinkOrder.get());
                }
            }else{
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void announceDone(Drink newDrink, Queue<Drink> todo) {
        Output.printDone(newDrink.getName());
        Output.printOrderStatus(drinkQueue,todo);

    }
}