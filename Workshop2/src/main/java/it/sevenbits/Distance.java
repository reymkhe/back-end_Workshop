package it.sevenbits;

/**
 *Distance set by two Points
 */
class Distance {
    private Point p1;
    private Point p2;

    /**
     *Distance constructor
     * @param p1 - point with coordinate (x;y)
     * @param p2 - point with coordinate (x;y)
     */
    Distance(final Point p1, final Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Measure function uses two Points and gets length of Distance
     * @return length of distance
     */
    double measure() {
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }
}
