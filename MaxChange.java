import java.io.*;
import java.lang.Integer;
import java.util.Arrays;

public class MaxChange {
    public static void main(String[] args) throws IOException {
        //http://people.cs.clemson.edu/~bcdean/dp_practice/dp_2.swf
        int[] A = {1, 2, 3}; // = 2
        int N = 4;
        System.out.println(ans(A, N));
    }

    public static int ans(int[] ar, int W) {
        //return minimum number of coins which add to val
        int[] wt = ar;
        int[] val = new int[wt.length];
        Arrays.fill(val, -1);

        int[][] arr = new int[wt.length][W + 1];

        for (int i = 0; i < arr.length; i++)
            Arrays.fill(arr[i], 0);
        for (int j = 0; j < arr[0].length; j++)//initializes first row
            if (wt[0] <= j)
                arr[0][j] = val[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (wt[i] > j)
                    arr[i][j] = arr[i - 1][j];//if item i can't fit, use best value when excluding this item (i.e. i-1)
                else
                    arr[i][j] = Math.max(arr[i - 1][j], val[i] + arr[i - 1][j - wt[i]]);
                //max of (without this item but same capacity, or with this item & capacity reduced by item's weight)
            }
        }
//        System.out.println(arr[arr.length - 1][arr[0].length - 1]);
        System.out.println(Arrays.deepToString(arr));
        return arr[arr.length-1][arr[0].length-1];
    }
}
