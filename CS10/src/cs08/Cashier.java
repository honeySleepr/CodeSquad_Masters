package cs08;

public class Cashier {
    private final DrinkQueue drinkQueue;

    public Cashier(DrinkQueue drinkQueue) {
        this.drinkQueue = drinkQueue;
    }

    public void takeOrder() {
        Order order = Input.extractOrder(); // 1:3 주문 = Order 1개 -> drink 3개

        for (int i = 0; i < order.getCount(); i++) {
            drinkQueue.addDrink(new Drink(order.getDrink()));
        }
    }

    public void repeatTakeOrder() {
       while(true){
           takeOrder();
       }

    }

    public boolean checkDuration() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (drinkQueue.peekOrder() == null) {
            return true;
        }
        return false;
    }

}