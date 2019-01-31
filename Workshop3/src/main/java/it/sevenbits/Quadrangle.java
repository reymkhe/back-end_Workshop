package it.sevenbits;


import java.util.Objects;

/**
 * Quadrangle set by lengths of four sides
 */
public class Quadrangle implements Polygon {

    private int a;
    private int b;
    private int c;
    private int d;

    /**
     * Quadrangle constructor
     * @param a - first side
     * @param b - second side
     * @param c - third side
     * @param d - fours side
     */
    public Quadrangle(final int a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * CalculatePerimeter function sums four sides of Quadrangle
     * @return perimeter of quadrangle
     */
    public int calculatePerimeter() {
        return a + b + c + d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(", ").append(b).append(", ").append(c).append(", ").append(d);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle that = (Quadrangle) o;
        return a == that.a &&
                b == that.b &&
                c == that.c &&
                d == that.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }
}
