package cs03;

public class MyList1 {
    Node head;
    Node temp;

    MyList1() {
        head = null;
        temp = null;
    }

    void add(Video clip) {

        Node node = new Node(clip);
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.link = node;
        }
        temp = node;
    }

    void add(String randomID) {

        Node node = new Node(randomID);
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.link = node;
        }
        temp = node;
    }

    void printAll() {
        System.out.println("---영상클립---");
        temp = head;
        while (temp != null) {
            System.out.println(temp.video.toString());
            temp = temp.link;
        }
    }

    Video[] save(){
        Video[] videoArray = new Video[13];
        temp = head;
        int i = 0;
        while (temp != null) {
            videoArray[i] = temp.video;
            temp = temp.link;
            i++;
        }
        return videoArray;
    }
}