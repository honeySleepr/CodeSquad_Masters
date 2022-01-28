package cs08;

public class Drink {
    private final String number;
    private String name;
    private int time;

    public Drink(String number) {
        this.number = number;
        setTime(number);
    }

    private void setTime(String number) {
        if ("1".equals(number)) {
            this.time = 3;
            this.name = "아메리카노";
            return;
        }
        if ("2".equals(number)) {
            this.time = 5;
            this.name = "카페라떼";

            return;

        }
        if ("3".equals(number)) {
            this.time = 10;
            this.name = "프라푸치노";

        }
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return number;
    }
}
