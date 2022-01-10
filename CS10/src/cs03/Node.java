package cs03;

public class Node {
    String id;
    Video video;
    Node link;

    Node(Video clip) {
        this.video = clip;
        this.link = null;
    }

    Node(String id) {
        this.id = id;
        this.link = null;
    }
}