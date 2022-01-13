package cs04;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Square implements Shape {
    List<Point> points;
    public Square(List<Point> points) {
        this.points = points;

    }

    @Override
    public double[] calLength() {
        double[] lengths = {0, 0};
        if (!checkValidSquare(points)) {
            System.out.println("직사각형만 가능!");
            return lengths;
        }
        Point p0 = points.get(0);
        int index = 0;
        for (int i = 1; i < points.size(); i++) {

            if (points.get(i).x == p0.x || points.get(i).y == p0.y) {
                lengths[index] = Math.abs(points.get(i).x - p0.x) + Math.abs(points.get(i).y - p0.y);
                index++;
            }
            if (lengths[1] != 0) {
                break;
            }
        }
        return lengths;
    }

    @Override
    public double calArea(double[] length) {
        return length[0] * length[1];
    }

    private boolean checkValidSquare(List<Point> points) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();

        for (Point p : points) {
            setX.add(p.x);
            setY.add(p.y);
        }
        if (setX.size() == 2 && setY.size() == 2) {
            return true;
        }
        return false;
    }
}