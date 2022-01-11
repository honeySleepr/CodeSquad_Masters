package cs03;

public class Video {
    private String id;
    private String title;
    private int length;



    Video(String title, int length, String id) {
        this.title = title;
        this.length = length;
        this.id = id;
    }


    @Override
    public String toString() {
        return title + "(" + id + "):" + length;
    }

    String getId() {
        return id;
    }

    int getLength() {
        return length;
    }
}