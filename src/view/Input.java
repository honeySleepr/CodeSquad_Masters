package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final String PROMPT_NAMES = "참가자들의 이름을 쉼표(,)로 구분하여 입력해주세요\n> ";
    private final String PROMPT_LADDERHEIGHT = "최대 사다리 높이는 몇 개인가요?\n> ";
    private final String PROMPT_NOTNUMBER = "숫자를 입력해주세요\n> ";
    private final String PROMPT_PRIZE = "상품을 쉼표(,)로 구분하여 입력해주세요\n> ";

    private List<String> names;
    private int ladderHeight;
    private List<String> prize;
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

    private void inputPrize() throws IOException {
        System.out.print(PROMPT_PRIZE);
        prize = new ArrayList<>();
        for (String st : processToList(br.readLine())) {
            prize.add(st);
        }
        matchSizeWithNames();
    }

    private void matchSizeWithNames() {
        while(prize.size() > names.size()){
           prize.remove(prize.size()-1);
        }
        while(prize.size() < names.size()){
            prize.add("꽝");
        }
    }

    private void inputName() throws IOException {
        System.out.print(PROMPT_NAMES);
        names = new ArrayList<>();
        for (String st : processToList(br.readLine())) {
            names.add(trimToFiveLetters(st));
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

    public List<String> getNameList() {
        return names;
    }

    public int getHeight() {
        return ladderHeight;
    }

    public List<String> getPrizeList() {
        return prize;
    }
}
