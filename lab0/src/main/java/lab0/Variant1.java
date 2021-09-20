package lab0;


public class Variant1 {


    /**
     *
     * @param n is array size
     * @param m is an array of ints
     * @return minimum
     */
    public int minMaxTask(int n, int[] m) {
        assert n > 0: "Array must be not empty";
        int min = m[0];
        for (int i = 0; i < n; i++){
            if(m[i] < min) min = m[i];
        }
        return min;
    }

    /**
     *
     * @param a, b - positive numbers, a > b
     * @return how many B segments can be placed on A with no overlaps
     */

    public int integerNumbersTask(int a, int b) {
        assert 0 < b && 0 < a && a > b: "Error";
        return a / b;
    }

    /**
     *
     * @param a, b - integers
     * @return true, if a > 2 and b<=3
     */
    public boolean booleanTask(int a, int b) {
        return a > 2 && b <= 3;
    }


    /**
     *
     * @param x1, x2, x3 are integer numbers
     * @return count of positive Xs
     */
    public int ifTask(int x1, int x2, int x3) {
        int count = 0;
        if(x1 >= 0) count = 1;
        if(x2 >= 0) count++;
        if(x3 >= 0) count += 1;
        return count;
    }


    /**
     *
     * @param month is a month of a not leap year
     * @return how many days has this month
     */
    public int switchTask(int month) {
        assert ((month <= 12) && (1 <= month)): "That's not a month";

        // here IDE proposed me to change my switch statement to an enhanced switch, it seems better than classic one
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
    }


    /**
     *
     * @param n is integer number
     * @return approximated value of exp(1)
     */

    public int[] forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        int[] result = new int[10];
        for(int i = 1; i <= 10; i++){
            result[i-1] = i * n;
        }

        return result;
    }


    public boolean whileTask(int n) {
        assert n > 0: "Argument should be more than zero";
        int i = n;
        while(i >= 3){
            if(i == 3) return true;
            else {
                i = i / 3;
            }
        }
        return false;
    }

    public int[] arrayTask(int n, int a, int d) {
        assert n > 1: "A is the size of returning array, it can't be less than 1";
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = a + d * i;
        }
        return res;
    }

    /**
     *
     * @param m is count of matrix strings
     * @param n is length of matrix string
     * @param array is an array of length n
     * @return matrix, which strings contain our array in same order
     */
    public int[][]  twoDimensionArrayTask(int m, int n, int[] array) {
        int[][]matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = array[j];
            }
        }
        return matrix;
    }


    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}