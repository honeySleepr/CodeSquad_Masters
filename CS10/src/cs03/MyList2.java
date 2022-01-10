package cs03;

import java.util.List;

public class MyList2 {
    Node head;
    Node temp;

    MyList2() {
        head = null;
        temp = null;
    }

    void add(List<String> command) {
        Node node = new Node(command.get(1));
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.link = node;
        }
        temp = node;
    }
}
