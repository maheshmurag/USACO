import java.io.*;
import java.util.Arrays;

public class MaxSumContiguousSubsequence {
    public static void main(String[] args) throws java.io.IOException {
        int[] A = {-2, 11, -4, 13, -5, 2};
//        int [] A = {-15, 29, -36, 3, -22, 11, 19, -5};
        //http://karmaandcoding.blogspot.com/2012/02/dynamic-programming-maximum-value.html
        //http://people.cs.clemson.edu/~bcdean/dp_practice/dp_1.swf
        System.out.println(ans(A));
    }

    public static int ans(int[] arr) {
        int start = 0, end, sum = arr[0], max = -1;
        for (int i = 1; i < arr.length; i++) {
            //choice: include i or don't include i or start a new contiguous place
            if (arr[i] + sum > sum) {
                sum += arr[i];
            } else {
                if (sum > max)
                    max = sum;
                sum = arr[i];
            }
        }
        return sum;
    }
}

