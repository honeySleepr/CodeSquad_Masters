package cs04;

import java.util.ArrayList;
import java.util.List;

public class Point {
    int x;
    int y;

    Point() {
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    List<Point> createPoints(String[] st) {
        List<Point> points = new ArrayList<>();

        for (String s : st) {
            String p1 = s.substring(s.indexOf("(") + 1, s.indexOf(","));
            String p2 = s.substring(s.indexOf(",") + 1, s.indexOf(")"));
            points.add(new Point(Integer.parseInt(p1), Integer.parseInt(p2)));
        }
        return points;
    }


}
