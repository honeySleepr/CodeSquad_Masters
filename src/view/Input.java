package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Player;
import domain.Prize;

public class Input {
    private final String PROMPT_NAMES = "참가자들의 이름을 쉼표(,)로 구분하여 입력해주세요\n> ";
    private final String PROMPT_LADDERHEIGHT = "최대 사다리 높이는 몇 개인가요?\n> ";
    private final String PROMPT_NOTNUMBER = "숫자를 입력해주세요\n> ";
    private final String PROMPT_PRIZE = "상품을 쉼표(,)로 구분하여 입력해주세요 (예: 0,5k,100k)\n> ";

    private List<Player> playerList = new ArrayList<>();
    private int ladderHeight;
    private List<Prize> prizeList = new ArrayList<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void processInput() {
        try {
            inputName();
            inputPrize();
            inputHeight();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    private void inputName() throws IOException {
        System.out.print(PROMPT_NAMES);
        List<String> temp = processToList(br.readLine());
        String name;
        for (int i = 0; i < temp.size() ; i++) {
            name = trimToFiveLetters(temp.get(i));
            playerList.add(new Player(name,i));
        }
    }
    private void inputPrize() throws IOException {
        System.out.print(PROMPT_PRIZE);
        List<String> temp = processToList(br.readLine());
        String prize;
        for (int i = 0; i < temp.size() ; i++) {
            prize = trimToFiveLetters(temp.get(i));
            prizeList.add(new Prize(prize,i));
        }
        matchCountWithNames();
    }

    private void matchCountWithNames() {
        while(prizeList.size() > playerList.size()){
           prizeList.remove(prizeList.size()-1);
        }
        while(prizeList.size() < playerList.size()){
            prizeList.add(new Prize("0", prizeList.size()));
        }
    }

    private void inputHeight() throws IOException {
        System.out.print(PROMPT_LADDERHEIGHT);
        String input;
        while (!isValid((input = br.readLine()))) {
            System.out.print(PROMPT_NOTNUMBER);
        }
        ladderHeight = Integer.parseInt(input);
    }

    private String trimToFiveLetters(String name) {
        if (name.length() > 5) {
            return name.substring(0, 5);
        }
        return name;
    }

    private boolean isValid(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }

    private List<String> processToList(String nameInput) {
        return Arrays.stream(nameInput.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public List<Player> getNameList() {
        return playerList;
    }

    public int getHeight() {
        return ladderHeight;
    }

    public List<Prize> getPrizeList() {
        return prizeList;
    }
}
