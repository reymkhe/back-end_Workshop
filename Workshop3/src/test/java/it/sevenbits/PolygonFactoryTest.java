package it.sevenbits;

import it.sevenbits.exceptions.TriangleException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for class PolygonFactory function getPolygonsFromFile
 */
public class PolygonFactoryTest {

    PolygonFactory factory = new PolygonFactory();
    FileWriter fileWriter;

    /**
     * Simple positive test. All conditions for the existence of polygons are met.
     * List should have polygons with sides from the file.
     * @throws IOException when File is not found
     * @throws TriangleException when Triangle is not exist
     */
    @Test
    public void listShouldHaveSomePolygons() throws IOException, TriangleException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("6 4 8\n2 3 5 2");
        fileWriter.close();
        List<Polygon> expectedPoligons = new ArrayList<Polygon>() {{
            add(new Triangle(6, 4, 8));
            add(new Quadrangle(2, 3, 5, 2));
        }};
        List<Polygon> actualPoligons = factory.getPolygonsFromFile("Polygons for test");

        Assert.assertArrayEquals(expectedPoligons.toArray(), actualPoligons.toArray());
    }

    /**
     * Conditions for the existence of polygons are met for only one polygon.
     * List should have only one polygon with sides from the file.
     * Test should finished with messages "Can`t create polygon from line (+ line number)".
     * @throws IOException when File is not found
     * @throws TriangleException when Triangle is not exist
     */
    @Test
    public void listShouldHaveOnlyOnePolygon() throws IOException, TriangleException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("6 4\n2 3 5 2\n5 6");
        fileWriter.close();
        List<Polygon> expectedPoligons = new ArrayList<Polygon>() {{
            add(new Quadrangle(2, 3, 5, 2));
        }};
        List<Polygon> actualPoligons = factory.getPolygonsFromFile("Polygons for test");

        Assert.assertArrayEquals(expectedPoligons.toArray(), actualPoligons.toArray());
    }

    /**
     * File have Integer variable, but number of sides from the file are not equal to sides of polygons.
     * Polygons are not exist. List is empty.
     * Test should finished with messages "Can`t create polygon from line (+ line number)".
     * @throws IOException when File is not found
     * @throws TriangleException when Triangle is not exist
     */
    @Test
    public void canNotCreatePolygons() throws IOException, TriangleException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("6 4\n2 3 5 2 5\n1 2 ");
        fileWriter.close();
        List<Polygon> expectedPoligons = new ArrayList<Polygon>() {{}};
        List<Polygon> actualPoligons = factory.getPolygonsFromFile("Polygons for test");

        Assert.assertArrayEquals(expectedPoligons.toArray(), actualPoligons.toArray());
    }

    /**
     * File have Integer variable, number of sides from the file are equal to sides of polygons, but separator are wrong.
     * Polygons are not exist. List is empty.
     * Test should finished with messages "Can`t create polygon from line (+ line number)".
     * @throws IOException when File is not found
     * @throws TriangleException when Triangle is not exist
     */
    @Test
    public void canNotUseLineFromFile() throws IOException, TriangleException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("6,4,3,5\n6,4,8");
        fileWriter.close();
        List<Polygon> expectedPoligons = new ArrayList<Polygon>() {{}};
        List<Polygon> actualPoligons = factory.getPolygonsFromFile("Polygons for test");

        Assert.assertArrayEquals(expectedPoligons.toArray(), actualPoligons.toArray());
    }

    /**
     * Exception test
     * @throws IOException when File is not found
     */
    @Test (expected = IOException.class)
    public void fileNotFoundTest() throws IOException, TriangleException {
        factory.getPolygonsFromFile("Some file");
    }

    /**
     * Exception test
     * @throws TriangleException when Triangle is not exist: at least one side is null or sum of two sides is not more than a third
     */
    @Test (expected = TriangleException.class)
    public void triangleIsNotExist() throws IOException, TriangleException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("0 4 5\n1 2 3");
        fileWriter.close();
        factory.getPolygonsFromFile("Polygons for test");
    }

    /**
     * Exception test. There is String variable in the file instead of Integer
     * @throws NumberFormatException when variable in the file not Integer
     */
    @Test (expected = NumberFormatException.class)
    public void stringDataInFile() throws IOException, TriangleException, NumberFormatException {
        fileWriter = new FileWriter("Polygons for test");
        fileWriter.write("six four eleven");
        fileWriter.close();
        factory.getPolygonsFromFile("Polygons for test");
    }
}



