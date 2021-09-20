package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant1;
import lab0.Variant1.DAY_OF_WEEK;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestVariant1 {

    public static double EPS = 0.0000001;

    @Test
    public void MassTest(){
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    /*@Test(enabled = false)
    public void loginOld() {

        assertEquals(new Variant1().booleanTask(3), false);

    }*/

    /*@Test(dataProvider = "inputProvider")
    public void inputTest(int p1, long p3) {
        assertEquals(new Variant1().inputOutputTask(p1), p3);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { { 2, 4l }, { 6, 36L } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeInputTest() {
        new Variant1().inputOutputTask(-2);
    }*/

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1,int p2, int p3) {
        assertEquals(new Variant1().integerNumbersTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, 10, 10 }, {47, 12, 3 }, { 139, 1, 139 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeIntegerProvider")
    public void negativeIntegerTest(int n1, int n2) {
        new Variant1().integerNumbersTask(n1, n2);
    }

    @DataProvider
    public Object[][] negativeIntegerProvider() {
        return new Object[][] { {-1, -3}, {10, 13}, {1, 0}};
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant1().ifTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] ifProvider() {

        return new Object[][] { { 2, 3, -1, 2 }, {-2, 0, 0, 2 }, { -3, -3, -3, 0 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant1().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { {3, 5, false }, { 3, 0, true }, { -3, 6, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, DAY_OF_WEEK p2) {
        assertEquals(new Variant1().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, DAY_OF_WEEK.WEDNESDAY }, { 6, 6 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant1().forTask(10);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, int[] res) {
        assertEquals(new Variant1().forTask(n), res);
        //Arrays.equals(new Variant1().forTask(n), res);
    }

    @DataProvider
    public Object[][] forProvider() {
        /*int[] nums1 = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int[] nums2 = {7, 14, 21, 28, 35, 42, 49, 56, 63, 70};
        int[] nums3 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};*/
        return new Object[][] { { 3, new Object[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30}},
                { 7, new Object[]{7, 14, 21, 28, 35, 42, 49, 56, 63, 70} }, { 2,  new Object[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}} };
    }

    //string ver
    /*@Test(dataProvider = "forProvider")
    public void forTest(int n, String res) {
        assertEquals(new Variant1().forTask(n), res);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, "3, 6, 9, 12, 15, 18, 21, 24, 27, 30"},
                { 7, "7, 14, 21, 28, 35, 42, 49, 56, 63, 70" }, { 2,  "2, 4, 6, 8, 10, 12, 14, 16, 18, 20"} };
    }*/

    ///////////////////////////////////////////////////


    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, boolean a) {
        assertEquals(new Variant1().whileTask(n), a);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 3,  true}, { 21, false}, { 27, true }, { 25, false } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int n) {
        new Variant1().whileTask(n);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -1 }, { -2 }, { 0 } };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double value) {
        assertEquals(new Variant1().arrayTask(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new double[] { 10, 2, 3 }, 0 }, { new double[] { 10, 2, 13 }, 10 },
                { new double[] { 4, 3, 5, -4, 9, 2 }, -4 } };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int from, int to, int[][] output) {
        assertEquals(new Variant1().twoDimensionArrayTask(input, from, to), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input23 = {{2, 3, 6, 9, -9},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input14 = {{-98, 8, 1, 5, 3},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        return new Object[][] { {input, 2, 3, input23}, { input, 1,4, input14 } };

    }

    @Test
    public void arrayTest2(){
        assertEquals(new int[]{2, 3}, new int[]{2, 3});
    }

}