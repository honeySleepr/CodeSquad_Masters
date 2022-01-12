package cs03;

public class MyList {
    Node head;
    Node temp;

    MyList() {
        head = null;
        temp = null;
    }

    void addLast(Node node) {
        temp = head;
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void insert(Node node, int index) {
        temp = head;
        // 인덱스 0 입력하거나, List가 비어있을 경우
        if (index == 0 || temp == null) {
            node.next = temp;
            head = node;
        } else {
            for (int i = 1; i < index; i++) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    void delete(Node node) {
        temp = head;
        //delete 할 항목이 head에 있을 때
        if (temp.videoNode == node.videoNode) {
            head = temp.next;
        } else {
            while (temp.next != null) {
                if (temp.next.videoNode == node.videoNode) {
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    void printAll() {
        System.out.println("---영상클립---");
        temp = head;
        while (temp != null) {
            System.out.println(temp.videoNode.toString());
            temp = temp.next;
        }
    }

    Video[] save() {
        Video[] videoArray = new Video[13];
        temp = head;
        int i = 0;
        while (temp != null) {
            videoArray[i] = temp.videoNode;
            temp = temp.next;
            i++;
        }
        return videoArray;
    }

    void printTimeLine() {
        temp = head;
        System.out.print("|---");
        while (temp != null) {
            System.out.printf("[%s, %d" + "sec]", temp.videoNode.getId(),
                temp.videoNode.getLength());
            System.out.print("---");
            temp = temp.next;
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
            temp = temp.next;
        }
        System.out.println("영상클립 :" + count + "개");
        System.out.println("전체길이 :" + length + "sec");
    }

}