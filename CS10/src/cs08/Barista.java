package cs08;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

public class Barista {
    private int task = 0;
    private final Queue<Drink> todo = new LinkedList<>();

    public boolean isReady() {
        if (todo.size() < 2) {
            return true;
        }
        return false;
    }

    public void callBarista(Manager manager) {
        waitOneSecond();  // todo 가 채워지기도 전에 실행되어 바로 return 되는걸 방지

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (task < 2) {
                System.out.println("task : " + task);
                CompletableFuture.runAsync(() -> startWork(manager));
                startWork(manager);
            }

        }

    }

    private void startWork(Manager manager) {

        Optional<Drink> newDrink = Optional.ofNullable(makeDrink());
        if (newDrink.isPresent()) {
            increaseTaskCount();
            System.out.println("task-- : " + task);
            sendDrink(newDrink.get(), manager);


            decreaseTaskCount();

        } else {
            return;
        }
    }
    private synchronized void increaseTaskCount() {
        this.task++;
    }
    private synchronized void decreaseTaskCount() {
        this.task--;
    }



    public Drink makeDrink() {

        int coolTime = 0;

        Optional<Drink> drink = Optional.ofNullable(todo.poll());
        if (drink.isPresent()) {
            task++;
            Drink theDrink = drink.get();
            Output.printStart(theDrink.getName());
            coolTime = theDrink.getTime();
            try {
                Thread.sleep(coolTime * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return theDrink;

        } else {
            // App.loop = false;
            return null;
        }
    }

    public void updateTodo(Drink drink) {
        this.todo.add(drink);
    }

    private void sendDrink(Drink newDrink, Manager manager) {
        manager.announceDone(newDrink, todo);
    }

    public void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}