package it.sevenbits;

/**
 * Point with two coordinate
 */
class Point {
    private int x;
    private int y;

    private Point() {
    }

    /**
     * Point constructor
     * @param x - first coordinate
     * @param y - second coordinate
     */
    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
