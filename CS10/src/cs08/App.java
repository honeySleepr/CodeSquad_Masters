package cs08;

import java.util.concurrent.CompletableFuture;

public class App {
    public static boolean loop = true;

    // 처음 한번 실행 : takeOrder (첫주문)
    // Background 실행 : callManager (1초마다 주문 전달)
    // Background 실행 : startWork (음료 제조)   -> 동시에 2개씩은 아직 미구현..
    // Background 실행 : repeatTakeOrder (추가 주문)


    public static void main(String[] args) {
        DrinkQueue drinkQueue = new DrinkQueue();
        Barista barista = new Barista();
        Manager manager = new Manager(barista, drinkQueue);
        Cashier cashier = new Cashier(drinkQueue);
        // 슈퍼 강한 결합;;

        Output.printInit();
        cashier.takeOrder();

        // 매니저와는 상관없이 추가 주문은 언제나 가능해야한다
        CompletableFuture.runAsync(cashier::repeatTakeOrder);
        // 추가 주문을 안해도 매니저는 계속 일해야한다
        CompletableFuture.runAsync(manager::sendOrder);

        //
        barista.callBarista(manager);


        // while (loop) {
        //     try {
        //         Thread.sleep(500);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
    }

}