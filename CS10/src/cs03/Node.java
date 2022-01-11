package cs03;

public class Node {
    String idNode;
    Video videoNode;
    Node linkNode;

    Node(Video video) {
        this.videoNode = video;
        this.linkNode = null;
    }

    Node(String idNode) {
        this.idNode = idNode;
        this.linkNode = null;
    }
}