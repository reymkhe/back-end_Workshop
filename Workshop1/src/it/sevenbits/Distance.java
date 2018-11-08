package it.sevenbits;

public class Distance {
    Point p1;
    Point p2;

    public Distance(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double measure() {
        return Math.sqrt(Math.pow((p2.getX()-p1.getX()), 2)+Math.pow((p2.getY()-p1.getY()), 2));
    }
}
