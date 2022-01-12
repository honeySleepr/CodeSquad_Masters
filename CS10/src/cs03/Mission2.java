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
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
                input = br.readLine().split("\\s+");
                command.addAll(List.of(input));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sign = verifyCommand(command);
            if (sign.equals("proceed")) {
                run(command);
            } else if (sign.equals("quit")) {
                return;
            }
            command.clear();
        }
    }

    String verifyCommand(List<String> command) {
        if(command.size() == 0){
            return "";
        }
        if (command.get(0).equals("add")
            || command.get(0).equals("insert")
            || command.get(0).equals("delete")
            || command.get(0).equals("render")) {
            return "proceed";
        }
        if (command.contains("quit")) {
            return "quit";
        }
        if (command.size() < 2) {
            System.out.println("명령어 : add, insert, delete, render");
            return "";
        }

        System.out.println("명령어 : add, insert, delete, render");
        return "";

    }

    void run(List<String> command) {
        if (command.get(0).equals("add")) {
            checkBeforeAdd(command);
        } else if (command.get(0).equals("insert")) {
            checkBeforeInsert(command);
        } else if (command.get(0).equals("delete")) {
            checkBeforeDelete(command);
        } else if (command.get(0).equals("render")) {
            myList.render();
        }
    }

    private void checkBeforeAdd(List<String> command) {

        if (command.size() != 2) {
            System.out.println("add {id} 입력");
            return;
        }
        Video video = searchArrayForId(command.get(1));
        if (video != null) {
            Node node = new Node(video);
            myList.addLast(node);
            myList.printTimeLine();
            return;
        } else {
            System.out.println("id가 존재하지 않습니다");
        }
    }

    private void checkBeforeInsert(List<String> command) {
        if (command.size() != 3) {
            System.out.println("insert {id} {index} 입력");
            return;
        }
        Video video = searchArrayForId(command.get(1));
        if (video != null) {
            Node node = new Node(video);
            // 인덱스에 문자 입력시 예외 처리
            try {
                int index = Integer.parseInt(command.get(2));
                myList.insert(node, index);
                myList.printTimeLine();
            } catch (Exception e) {
                System.out.println("index는 숫자를 입력해주세요");
            }

        } else {
            System.out.println("id가 존재하지 않습니다");
        }
    }

    private void checkBeforeDelete(List<String> command) {
        if (command.size() != 2) {
            System.out.println("delete {id} 입력");
            return;
        }
        Video video = searchTimelineForId(command.get(1));
        if (video != null) {
            Node node = new Node(video);
            myList.delete(node);
            myList.printTimeLine();
        } else {
            System.out.println("id가 존재하지 않습니다");
        }

    }

    Video searchArrayForId(String id) {
        for (Video video : videoArray) {
            if (video.getId().equals(id)) {
                return video;
            }
        }
        return null;
    }

    Video searchTimelineForId(String id) {
        myList.temp = myList.head;
        while (myList.temp != null) {
            if (myList.temp.videoNode.getId().equals(id)) {
                return myList.temp.videoNode;
            } else {
                myList.temp = myList.temp.next;
            }
        }
        return null;
    }
}
