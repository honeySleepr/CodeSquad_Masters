package cs04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

    String[] getInput() {
        String input = receiveInput();
        return divideString(input);
    }

    private String receiveInput() {
        System.out.print("$> ");
        String input = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

    private String[] divideString(String input) {
        return input.split("-");
    }

}

