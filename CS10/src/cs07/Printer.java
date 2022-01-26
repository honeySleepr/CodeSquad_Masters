package cs07;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Printer {
   long startTime = System.currentTimeMillis();

    public void printReadyQueue(Queue<MyProcess> readyQueue) {
        System.out.println("이 프로그램은");
        readyQueue.stream()
            .sorted(Comparator.comparing(p -> p.name))
            .forEach(p -> System.out.println(p
                + " - 스레드 "
                + p.myThreadList.size()
                + "개"));

        int threadCount = readyQueue.stream()
            .map(p -> p.myThreadList.size())
            .reduce(0, (x, y) -> x + y);
        System.out.println("총 스레드는 " + threadCount + "개 입니다");
        System.out.println("------------------------");
    }

    public void printRunningStatus(List<Queue<MyProcess>> process) {
        process.stream()
            .flatMap(Queue::stream)
            .sorted(Comparator.comparing(p -> p.name))
            .forEach(System.out::println);

        System.out.println(
            "------------------------" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
    }

}
