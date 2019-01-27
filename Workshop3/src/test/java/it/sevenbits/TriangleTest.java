package it.sevenbits;

import it.sevenbits.exceptions.TriangleException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for class Triangle
 */
public class TriangleTest {

    /**
     * Simple positive test
     * @throws TriangleException when at least one side is null or sum of two sides is not more than a third
     */
    @Test
    public void simplePositiveCalculatePerimeterTest() throws TriangleException {
        Triangle triangle = new Triangle(5, 12, 8);
        Assert.assertEquals(25, triangle.calculatePerimeter());
    }


    /**
     * Exception test
     * @throws TriangleException when one side is null
     */
    @Test(expected = TriangleException.class)
    public void notExistTriangleCalculatePerimeterTest() throws TriangleException {
        Triangle triangle = new Triangle(0, 12, 8);
        triangle.calculatePerimeter();
    }
}
