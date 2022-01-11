package cs03;

public class MyList {
    Node head;
    Node temp;
    Node last;

    MyList() {
        head = null;
        temp = null;
        last = null;
    }

    void addLast(Node node) {
        temp = last;
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.linkNode = node;
        }
        temp = node;
        last = node;
    }

    void insert(Node node, int index) { /* < 진행 중 */
        temp = head;
        if(index == 0){

        }
        for (int i = 1; i < index-1; i++) {
            temp = temp.linkNode;
        }
    }

    void printAll() {
        System.out.println("---영상클립---");
        temp = head;
        while (temp != null) {
            System.out.println(temp.videoNode.toString());
            temp = temp.linkNode;
        }
    }

    Video[] save() {
        Video[] videoArray = new Video[13];
        temp = head;
        int i = 0;
        while (temp != null) {
            videoArray[i] = temp.videoNode;
            temp = temp.linkNode;
            i++;
        }
        return videoArray;
    }

    void printTimeLine() {
        temp = head;
        System.out.print("|---");
        while (temp != null) {
            System.out.printf("[%s, %d" + "sec]", temp.videoNode.getId(), temp.videoNode.getLength());
            System.out.print("---");
            temp = temp.linkNode;
        }
        System.out.println("[end]");
    }

    void render() {
        int count = 0;
        int length = 0;
        temp = head;
        while (temp != null) {
            count++;
            length += temp.videoNode.getLength();
            temp = temp.linkNode;
        }
        System.out.println("영상클립 :" + count + "개");
        System.out.println("전체길이 :" + length + "sec");
    }

}