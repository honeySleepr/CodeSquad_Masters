package cs03;

public class MyData {
    String id;
    String title;
    int length;
    MyData nextMyData;
    static MyData[] storage;
    static int lastIndex;

    public MyData(int size) {
        storage = new MyData[size];
        lastIndex = 0;
    }
    public MyData(String id, String title, int length, MyData nextMyData) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.nextMyData = nextMyData;
    }

    void add(MyData myData) {
        storage[lastIndex] = myData;
        lastIndex ++;
    }

    @Override
    public String toString() {
        return title+"("+id+"):"+length;
    }
}
