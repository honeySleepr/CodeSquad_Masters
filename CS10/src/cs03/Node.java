package cs03;

public class Node {
    String idNode;
    Video videoNode;
    Node next;

    Node(Video video) {
        this.videoNode = video;
        this.next = null;
    }

    Node(String idNode) {
        this.idNode = idNode;
        this.next = null;
    }
}