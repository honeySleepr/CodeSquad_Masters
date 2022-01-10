package cs03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Mission2 {
    Video[] videoArray;
    MyList2 myList2;

    public Mission2(Video[] videoArray, MyList2 myList2) {
        this.videoArray = videoArray;
        this.myList2 = myList2;
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
            } else if (sign.equals("quit")) {
                return;
            }
        }
    }

    String verifyCommand(List<String> command) {
        if (command.size() < 2) {
            System.out.println("명령어 + 공백 + 영상id 입력");
            return "";
        }
        if (command.contains("quit")) {
            return "quit";
        }
        if (command.get(0).equals("add") || command.get(0).equals("insert") || command.get(0).equals("delete")) {
            return "proceed";
        }

        System.out.println("명령어 : add, insert, delete");
        command.clear();
        return "";

    }

    void run(List<String> command) {
        if (command.get(0).equals("add")) {
            myList2.add(command);
        }
    }
}
