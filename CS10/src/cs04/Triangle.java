package cs04;

import java.util.List;

public class Triangle implements Shape {
    List<Point> points;
    Triangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public double[] calLength() {
        double[] lengths = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            int index = (i + 1) % points.size();
            double a = Math.pow((points.get(i).x - points.get(index).x), 2);
            double b = Math.pow((points.get(i).y - points.get(index).y), 2);
            lengths[i] = Math.sqrt(a + b);
        }
        return lengths;
    }

    @Override
    public double calArea(double[] lengths) {
        double a = lengths[0];
        double b = lengths[1];
        double c = lengths[2];
        double aa = Math.pow(a,2);
        double bb = Math.pow(b,2);
        double cc = Math.pow(c,2);

        return 0.25*Math.sqrt(4*aa*bb-Math.pow(aa+bb-cc,2));
    }
}
