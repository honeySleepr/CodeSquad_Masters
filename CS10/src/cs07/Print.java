package cs07;

import java.util.Queue;

public class Print {

    public void printConsole(Queue<myProcess> myProcessQueue) {
        for (myProcess p : myProcessQueue) {
            System.out.println(p.toString());
        }
    }
}

// 인쇄 할땐 리스트에 담고 이름으로 sort 하면 되겠지?