package cs08;

import java.util.Queue;

public class Output {
    private Output() {
    }

    public static void printInit() {
        System.out.println(Message.MENU);
        System.out.println(Message.INITMESSAGE);
        System.out.print(Message.PROMPT);

    }

    public static void printStart(String drink) {
        System.out.println(drink + Message.START);
    }

    public static void printDone(String drink) {
        System.out.println(drink + Message.COMPLETE);
    }

    public static void printExit() {
        System.out.println(Message.NOMOREORDER);
    }

    public static void printOrderStatus(DrinkQueue drinkQueue, Queue<Drink> todo) {
        System.out.print(todo + " <- ");
        System.out.println(drinkQueue.getQueue());

    }
}