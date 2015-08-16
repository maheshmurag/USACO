import java.io.*;
import java.util.Arrays;

public class MaxSumContiguousSubsequence {
    public static void main(String[] args) throws java.io.IOException {
//        int[] A = {-2, 11, -4, 13, -5, 2};// = 20
        int [] A = {-15, 29, -36, 3, -22, 11, 19, -5};// = 30
        //http://karmaandcoding.blogspot.com/2012/02/dynamic-programming-maximum-value.html
        //http://people.cs.clemson.edu/~bcdean/dp_practice/dp_1.swf
        System.out.println(ans(A));
    }

    public static int ans(int[] arr) {
        int[] M = new int[arr.length];
        int start = 0;
        M[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            M[i] = Math.max(arr[i], M[i - 1] + arr[i]);
            start = (M[i - 1] > 0) ? start : i;
        }
        int max = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < M.length; i++) {
            if(M[i] > max) {
                max = M[i];
                end = i;
            }
        }
        System.out.println("max ranges from index " + start + " to " + end);
        return max;
    }
}
