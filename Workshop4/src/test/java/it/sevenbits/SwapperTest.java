package it.sevenbits;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for class Swapper
 */
public class SwapperTest {

    Swapper swapper = new Swapper();

    /**
     * Simple positive test for doSwap function
     */
    @Test
    public void simplePositiveTest() {
        List<String> list = new ArrayList<>();
        list.add("ax");
        list.add("bx");
        list.add("cx");
        list.add("cy");
        list.add("by");
        list.add("ay");
        list.add("aaa");
        list.add("azz");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("ay");
        expectedList.add("by");
        expectedList.add("cy");
        expectedList.add("cx");
        expectedList.add("bx");
        expectedList.add("ax");
        expectedList.add("aaa");
        expectedList.add("azz");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using empty array
     */
    @Test
    public void arrayIsEmptyTest() {
        List<String> list = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        Assert.assertArrayEquals(expectedList.toArray(),swapper.doSwap(list).toArray());
    }

    /**
     * Test for doSwap function using array with not coinciding elements
     */
    @Test
    public void arrayWithNotCoincidingElementsTest() {
        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("ba");
        list.add("cf");
        list.add("vb");


        List<String> expectedList = new ArrayList<>();
        expectedList.add("ab");
        expectedList.add("ba");
        expectedList.add("cf");
        expectedList.add("vb");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using array with all equal elements
     */
    @Test
    public void arrayWithAllEqualElementsTest() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("aa");


        List<String> expectedList = new ArrayList<>();
        expectedList.add("aa");
        expectedList.add("aa");
        expectedList.add("aa");
        expectedList.add("aa");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using array with elements consisting of one character
     */
    @Test
    public void oneCharacterElementsTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("b");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("a");
        expectedList.add("b");
        expectedList.add("a");
        expectedList.add("a");
        expectedList.add("b");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using array with elements consisting of characters with different case
     */
    @Test
    public void usingRegisterTest() {
        List<String> list = new ArrayList<>();
        list.add("aB");
        list.add("bd");
        list.add("Ag");
        list.add("aa");
        list.add("Bj");
        list.add("ab");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("aa");
        expectedList.add("bd");
        expectedList.add("Ag");
        expectedList.add("aB");
        expectedList.add("Bj");
        expectedList.add("ab");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using array with elements consisting of special characters
     */
    @Test
    public void usingSpecialCharactersTest() {
        List<String> list = new ArrayList<>();
        list.add("@#");
        list.add("@@");
        list.add("#$");
        list.add("#!");
        list.add("###");
        list.add("&^");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("@@");
        expectedList.add("@#");
        expectedList.add("#!");
        expectedList.add("#$");
        expectedList.add("###");
        expectedList.add("&^");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    /**
     * Test for doSwap function using array with empty strings
     */
    @Test
    public void arrayWithNullStringsTest() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ab");
        list.add("");
        list.add("cb");
        list.add("");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("ab");
        expectedList.add("aa");
        expectedList.add("");
        expectedList.add("cb");
        expectedList.add("");

        List<String> actualList = swapper.doSwap(list);
        Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }
}

