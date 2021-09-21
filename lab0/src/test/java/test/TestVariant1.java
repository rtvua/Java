package test;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import lab0.Variant1;

public class TestVariant1 {
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
    public void switchTest(int p1, int p2) {
        assertEquals(new Variant1().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, 31 }, { 6, 30 }, {2, 28} };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "switchNegativeTestProvider")
    public void switchNegativeTest(int p1) {
        new Variant1().switchTask(p1);
    }

    @DataProvider
    public Object[][] switchNegativeTestProvider(){
        return new Object[][] { {0}, {-5}, {13}};
    }

    ///////////////////////////////////////////////////



///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, int[] res) {
        assertArrayEquals(new Variant1().forTask(n), res);
        assertEquals(new Variant1().forTask(n), res);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30}},
                { 7, new int[]{7, 14, 21, 28, 35, 42, 49, 56, 63, 70} },
                { 2,  new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}} };
    }


    @Test(expectedExceptions = AssertionError.class, dataProvider = "forNegativeTestProvider")
    public void forNegativeTest(int p1) {
        new Variant1().forTask(p1);
    }

    @DataProvider
    public Object[][] forNegativeTestProvider(){
        return new Object[][] {{0}, {-1}, {-10}};
    }

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

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int p1, int[] m, int p2){
        assertEquals(new Variant1().minMaxTask(p1, m), p2);
    }

    @DataProvider
    public Object[][] minMaxProvider() {
        return new Object[][] { {5, new int[] {1, 2, 3, 4, -5}, -5},
                {3, new int[] {1, 2, 3}, 1},
                {10, new int[]{15, 12, 10, 75, 34, 232, 4, 55, 77, 318}, 4},
                {1, new int[] {1}, 1}};
    }


    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int p1, int p2, int p3, int[] array) {
        assertEquals(new Variant1().arrayTask(p1, p2, p3), array);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { 3, 2, 1, new int[] {2, 3, 4} },
                {5, 10, 2, new int[] {10, 12, 14, 16, 18}},
                {2, 2, -2, new int[]{2, 0}}};
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int p1, int p2, int[] p3, int[][] output) {
        assertEquals(new Variant1().twoDimensionArrayTask(p1, p2, p3), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] output1 = {{2, 3, 6, 9},
                {2, 3, 6, 9},
                {2, 3, 6, 9},
                {2, 3, 6, 9},
                {2, 3, 6, 9}};

        int[][] output2 = {{-4, 2, 1},
                {-4, 2, 1},
                {-4, 2, 1}};

        int[][] output3 = {{-98, 8, 1, 5, 3},
                {-98, 8, 1, 5, 3},
                {-98, 8, 1, 5, 3},
                {-98, 8, 1, 5, 3}};

        return new Object[][] { {5, 4, new int[]{2, 3, 6, 9}, output1}, {3, 3, new int[]{-4, 2, 1}, output2},
                {4, 5, new int[]{-98, 8, 1, 5, 3}, output3}};

    }
}