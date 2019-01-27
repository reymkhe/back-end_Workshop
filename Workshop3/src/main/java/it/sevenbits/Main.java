package it.sevenbits;

import it.sevenbits.exceptions.TriangleException;

import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.Arrays;
import java.util.List;
//import java.util.Random;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     */
    public static void main(final String[] args) {
//        final int MAX_XY = 25;
//        Random rand = new Random();
//        Distance[] distances = new Distance[5];
//        for (int i = 0; i < distances.length; i++) {
//            distances[i] = new Distance(new Point(rand.nextInt(MAX_XY), rand.nextInt(MAX_XY)), new Point(rand.nextInt(MAX_XY), rand.nextInt(MAX_XY)));
//            System.out.printf("%.2f\n", distances[i].measure());
//        }
//
//        double max = distances[0].measure();
//        for (int i = 0; i < distances.length; i++) {
//            if (distances[i].measure() > max) {
//                max = distances[i].measure();
//            }
//        }
//        System.out.printf("Maximum distance is %.2f", max);

        PolygonFactory factory = new PolygonFactory();
        try {
            Polygon triangle = factory.getTriangle(6, 4, 8);
            System.out.println("triangle: " + triangle);
        } catch (TriangleException e) {
            System.out.println("triangle is not exist");
        }
        Polygon quadrangle = factory.getQuadrilateral(2, 3, 5, 4);
        System.out.println("quadrangle: " + quadrangle);

        try {
            List polygons = factory.getPolygonsFromFile("Polygons for main");
            for (int i = 0; i < polygons.size(); i++) {
            System.out.println(polygons.get(i));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (TriangleException te) {
            System.out.println("Triangle is not exist");
        }
    }
}
