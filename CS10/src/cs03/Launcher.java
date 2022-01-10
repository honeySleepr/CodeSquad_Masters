package cs03;

public class Launcher {
    public static void main(String[] args) {
        Mission1 mission1 = new Mission1(new MyList1(),new MyList1());
        Video[] videoArray = mission1.getVideoArray();

       new Mission2(videoArray,new MyList2());
    }
}
