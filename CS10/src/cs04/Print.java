package cs04;

import java.util.Arrays;
import java.util.List;

public class Print {

    private List<Point> points;

    Print(double area, List<Point> points) {
        this.points = points;
        String[][] table = createTable(points);
        printTable(table);
        printValue(area);
    }


    private String[][] createTable(List<Point> points) {
        // intelliJ 콘솔 세로 길이가 길어서 반으로 줄임
        String[][] table = new String[13][25];
        for (int i = 0; i < table.length; i++) {
            Arrays.fill(table[i], "　");
        }
        for (Point p : points) {
            table[table.length -1 -p.y/2][p.x] = "●";
        }
        return table;
    }

    private void printTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    private void printValue(double value) {
        value = Math.round(value*1000)/1000.0;
        if (points.size() == 2) {
            System.out.println("두 점 사이 거리는 " + value);
        }
        if (points.size() == 3) {
            System.out.println("삼각형의 넓이는 " + value);
        }
        if (points.size() == 4) {
            System.out.println("사각형의 넓이는 " + value);
        }
    }
}
