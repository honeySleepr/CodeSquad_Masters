package cs03;

import java.util.Random;

public class Mission1 {
    private final MyList1 videoList;
    private final MyList1 idList;

    Mission1(MyList1 videoList, MyList1 idList) {
        this.videoList = videoList;
        this.idList = idList;
        addVideo();
        videoList.printAll();
    }

    void addVideo() {
        for (int i = 0; i < 13; i++) {

            String title = "제목" + (i + 1);
            int length = new Random().nextInt(14) + 1;
            String id = createID();

            videoList.add(new Video(title, length, id));
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
            if (idList.temp.id.equals(sb.toString())) {
                sb.setLength(0);
                for (int i = 0; i < 4; i++) {
                    sb.append(Character.toString(random.nextInt(6) + 97));
                }
                idList.temp = idList.head;
            } else if (idList.temp.link != null) {
                idList.temp = idList.temp.link;
            } else {
                break;
            }
        }
        idList.add(sb.toString());
        return sb.toString();

    }
}
