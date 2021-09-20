package lab0;

public class Variant1 {


    /**
     *
     * @param k is square side
     * @return perimeter
     */
    public int inputOutputTask(int k) {
        return 0;
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
     * @param month
     * @return how many days has this month
     */
    public int switchTask(int month) {
        assert ((month <= 12) && (1 <= month)): "That's not a month";
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2: return 28;
            default: return 0;
        }
    }


    /**
     *
     * @param n is integer number
     * @return approximated value of exp(1)
     */
/*
    public int[] forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        int result[] = new int[n+1];
        for(int i = 1; i <= 10; i++){
            result[i-1] = i * n;
        }

        return result;
    }
*/


    public String forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        int num = 0;
        String result = "";
        for(int i = 1; i < 10; i++){
            num = i * n;
            result += num + ", ";
        }
        result += 10 * n;

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
        return 0;
    }

    /**
     *
     * @param array
     * @param k1
     * @param k2
     * @return transformed array where row with indexes k1 and k2 was changed
     */
    public int[][]  twoDimensionArrayTask(int[][] array, int k1, int k2) {
        //return null;
        return array;
    }


    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}