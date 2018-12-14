package it.sevenbits;

import java.util.Random;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        final int MAX_XY = 25;
        Random rand = new Random();
        Distance[] distances = new Distance[5];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = new Distance(new Point(rand.nextInt(MAX_XY), rand.nextInt(MAX_XY)), new Point(rand.nextInt(MAX_XY), rand.nextInt(MAX_XY)));
            System.out.printf("%.2f\n", distances[i].measure());
        }

        double max = distances[0].measure();
        for (int i = 0; i < distances.length; i++) {
            if (distances[i].measure() > max) {
                max = distances[i].measure();
            }
        }
        System.out.printf("Maximum distance is %.2f", max);
    }
}
