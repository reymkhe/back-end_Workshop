package it.sevenbits;

import it.sevenbits.exceptions.TriangleException;

/**
 * Triangle set by lengths of three sides
 */
public class Triangle implements Polygon {

    private int a;
    private int b;
    private int c;

    /**
     * Triangle constructor
     * @param a - first side
     * @param b - second side
     * @param c - third side
     * @throws TriangleException when at least one side is null or sum of two sides is not more than a third
     */
    public Triangle(final int a, final int b, final int c) throws TriangleException {

        if (a > 0 && b > 0 && c > 0 && (a + b) > c && (a + c) > b && (b + c) > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new TriangleException("not exist");
        }
    }

    /**
     * CalculatePerimeter function sums three sides of Triangle
     * @return perimeter of triangle
     */
    public int calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(", ").append(b).append(", ").append(c);
        return sb.toString();
    }
}
