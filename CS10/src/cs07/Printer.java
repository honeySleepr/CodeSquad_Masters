package cs07;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Printer {

    public void printInitStatus(Queue<myProcess> myProcessQueue) {
        myProcessQueue.stream()
            .sorted(Comparator.comparing(p->p.name))
            .forEach(System.out::println);

    }

    public void printRunningStatus(List<Queue<myProcess>> process){
        process.stream()
            .flatMap(Queue::stream)
            .sorted(Comparator.comparing(p->p.name))
            .forEach(System.out::println);
    }

    }
