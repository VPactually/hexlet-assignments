package exercise;

// BEGIN
public class Circle {
    private int radius;
    private Point point;

    public Circle(Point point, int radius) {
        this.radius = radius;
        this.point = point;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return radius * radius * Math.PI;
    }
}
// END
