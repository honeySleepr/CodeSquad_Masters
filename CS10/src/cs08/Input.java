package cs08;

import java.util.Scanner;

public class Input {

    private Input() {
    }

    public static Order extractOrder() {
        Scanner scanner = new Scanner(System.in);
        String inputOrder = scanner.nextLine();
        String[] menuAndCount = inputOrder.split(":");
        //1:3
        return new Order(menuAndCount[0], Integer.parseInt(menuAndCount[1]));
    }
}
