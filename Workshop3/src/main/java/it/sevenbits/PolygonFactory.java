package it.sevenbits;

import it.sevenbits.exceptions.TriangleException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory for polygons
 */
public class PolygonFactory {

    /**
     * Function creates Triangle by three sides
     * @param a -first side
     * @param b - second side
     * @param c - third side
     * @return Triangle
     * @throws TriangleException when at least one side is null or sum of two sides is not more than a third
     */
    public Triangle getTriangle(final int a, final int b, final int c) throws TriangleException {
        return new Triangle(a, b, c);
    }

    /**
     * Function creates Quadrangle by four sides
     * @param a - first side
     * @param b - second side
     * @param c - third side
     * @param d - fours side
     * @return Quadrangle
     */
    public Quadrangle getQuadrilateral(final int a, final int b, final int c, final int d) {
        return new Quadrangle(a, b, c, d);
    }

    /**
     * GetPolygonsFromFile function creates polygons by three or four sides. Sides is Integer.
     * Sides are contained in file and separated by spaces. One line it`s one polygon.
     * @param path - path to file containing sides of polygons
     * @return List containing polygons with sides from file
     * @throws TriangleException when Triangle is not exist
     * @throws IOException when File is not found
     * @throws NumberFormatException when variable in the file not Integer
     */
    public List<Polygon> getPolygonsFromFile(final String path) throws TriangleException, IOException, NumberFormatException {
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader( new File(path)));
        String line;
        List <Polygon> polygons = new ArrayList<>();
        while ((line = lineNumberReader.readLine()) != null) {
            String[] splittedLine = line.split(" ");
            switch (splittedLine.length) {
                case 3:
                    polygons.add(getTriangle(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]),
                            Integer.parseInt(splittedLine[2])));
                    break;
                case 4:
                    polygons.add(getQuadrilateral(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]),
                            Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[3])));
                    break;
                default:
                    System.out.println("Can`t create polygon from line " + lineNumberReader.getLineNumber());
                    break;
            }
        }
        return polygons;
    }
}

