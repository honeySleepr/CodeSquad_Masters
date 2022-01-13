package cs04;

import java.util.List;

public class Line implements Shape {
    List<Point> points;
    Line(List<Point> points) {
      this.points = points;
    }

    @Override
    public double[] calLength() {
        double a = Math.pow((points.get(0).x - points.get(1).x), 2);
        double b = Math.pow((points.get(0).y - points.get(1).y), 2);
        return new double[]{Math.sqrt(a+b)};
    }

    @Override
    public double calArea(double[] length) {
        return length[0];
    }
}
