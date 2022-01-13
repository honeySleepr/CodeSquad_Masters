package cs04;

import java.util.List;

public class Controller {
    Input input;
    Point point;

    public Controller(Input input, Point point) {
        this.input = input;
        this.point = point;
    }

    void start() {
        while (true) {
            String[] inputs = input.getInput();
            if (inputs[0].equals("quit")) {
                return;
            }
            List<Point> points = point.createPoints(inputs);
            Shape shape = getShape(points);
            double[] length = shape.calLength();
            double area = shape.calArea(length);
            new Print(area, points);
        }
    }

    Shape getShape(List<Point> points) {

        switch (points.size()) {
            case 2:
                return new Line(points);
            case 3:
                return new Triangle(points);
            case 4:
                return new Square(points);
            default:
                System.out.println("다각형은 아직..");
                return null;
        }
    }
}
