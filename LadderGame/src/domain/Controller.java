package domain;

import view.Input;
import view.Output;

public class Controller {
    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void runApp() {
        input.processInput();
        LadderMaker ladderMaker = new LadderMaker(input.getNameList(), input.getPrizeList(),
            input.getHeight());
        ladderMaker.make();
        ladderMaker.calculate();

        output.printGameComponents(input.getNameList(), 6);
        output.printLadder(ladderMaker.getLadderList());
        output.printGameComponents(input.getPrizeList(), 6);

    }

}
