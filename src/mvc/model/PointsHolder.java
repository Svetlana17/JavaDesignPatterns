package mvc.model;

import java.util.ArrayList;
import java.util.List;

public class PointsHolder {

    private static PointsHolder instance = new PointsHolder();

    public static PointsHolder getInstance() {
        return instance;
    }

    private final List<Point> points;

    private PointsHolder() {
        points = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            points.add(new Point(i, i * i));
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
