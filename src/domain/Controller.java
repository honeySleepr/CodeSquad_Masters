package domain;

import view.Input;
import view.Output;

public class Controller{
    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void runApp() {
        input.processInput();
        LadderMaker ladderMaker = new LadderMaker(input.getNameList().size(), input.getHeight());
        ladderMaker.make();

        output.printNameAndPrize(input.getNameList(), 6);
        output.printLadder(ladderMaker.getLadderList());
        output.printNameAndPrize(input.getPrizeList(), 6);



    }

}
