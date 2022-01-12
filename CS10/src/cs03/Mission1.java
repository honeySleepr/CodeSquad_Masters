package cs03;

import java.util.Random;

public class Mission1 {
    private final MyList videoList;
    private final MyList idList;

    Mission1(MyList videoList, MyList idList) {
        this.videoList = videoList;
        this.idList = idList;
        addVideo();
        videoList.printAll();
    }

    void addVideo() {
        for (int i = 0; i < 13; i++) {

            String title = "제목" + (i + 1);
            int length = new Random().nextInt(15) + 1;
            String id = createID();

            Node node = new Node(new Video(title, length, id));
            videoList.addLast(node);
        }

    }

    Video[] getVideoArray(){
        return videoList.save();
    }

    String createID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(Character.toString(random.nextInt(6) + 97));
        }
        idList.temp = idList.head;
        while (idList.temp != null) {
            if (idList.temp.idNode.equals(sb.toString())) {
                sb.setLength(0);
                for (int i = 0; i < 4; i++) {
                    sb.append(Character.toString(random.nextInt(6) + 97));
                }
                idList.temp = idList.head;
            } else if (idList.temp.next != null) {
                idList.temp = idList.temp.next;
            } else {
                break;
            }
        }
        Node node = new Node(sb.toString());
        idList.addLast(node);
        return sb.toString();
    }
}
