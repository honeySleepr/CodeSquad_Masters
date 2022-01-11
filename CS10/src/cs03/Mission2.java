package cs03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Mission2 {
    Video[] videoArray;
    MyList myList;

    public Mission2(Video[] videoArray, MyList myList) {
        this.videoArray = videoArray;
        this.myList = myList;
        runConsole();
    }

    void runConsole() {
        String[] input;
        ArrayList<String> command = new ArrayList<>();
        while (true) {
            System.out.print("> ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine().split("\\s+");
                command.addAll(List.of(input));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sign = verifyCommand(command);
            if (sign.equals("proceed")) {
                run(command);
                command.clear();
            } else if (sign.equals("quit")) {
                return;
            }

        }
    }

    String verifyCommand(List<String> command) {
        if (command.size() < 2 && !command.get(0).equals("render") && !command.get(0).equals("quit")) {
            System.out.println("명령어 + 공백 + 영상id 입력");
            return "";
        }
        if (command.contains("quit")) {
            return "quit";
        }

        if (command.get(0).equals("add")
            || command.get(0).equals("insert")
            || command.get(0).equals("delete")
            || command.get(0).equals("render")) {
            return "proceed";
        }
        /* ^ 개선하기*/

        System.out.println("명령어 : add, insert, delete");
        command.clear();
        return "";

    }

    void run(List<String> command) {
        Video video;
        if (command.get(0).equals("add")) {
            if ((video = findID(command.get(1))) != null) {
                Node node = new Node(video);
                myList.addLast(node);
                myList.printTimeLine();
                return;
            }
            System.out.println("id가 존재하지 않습니다");
        }
        if (command.get(0).equals("insert") && command.size()==3) {
            if ((video = findID(command.get(1))) != null){
                Node node = new Node(video);
                int index = Integer.parseInt(command.get(2));
                myList.insert(node, index);
            }
        }

        if (command.get(0).equals("delete")) {

        }
        if (command.get(0).equals("render")) {
            myList.render();
        }
    }

    Video findID(String id) {
        for (Video video : videoArray) {
            if (video.getId().equals(id)) {
                return video;
            }
        }
        return null;
    }
}
