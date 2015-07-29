/*
TASK: subset
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.lang.Math;
import java.util.Arrays;


public class subset {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "subset";
        StreamTokenizer input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        input.nextToken();
        int n=(int)input.nval;
        int totalSum=0;
        for (int i = 1;i <= n; i++)
            totalSum+=i;
        if(totalSum % 2 != 0)//if totalsum is odd, then it can't be halved: there can't be 2 subsets who share the same sum
            output.println(0);
        else{
            int target = totalSum/2;//what each subset should sum to
            long[] arr = new long[target+1];//stores the max possible # subsets which sum to index i (arr[5] is how many sum to 5)
            arr[0] = 1;//there will always only be 1 subset that sums to 0 []
            int currentSum = 0;
            for (int i = 1; i <= n; i++)
            {
                currentSum += i;
                for (int j = Math.min(target, currentSum); j >= i; j--)
                {
//                    System.out.println("i: " + i + " j: " + j +" currentSum: " + currentSum +": " + Arrays.toString(arr));
                    arr[j] += arr[j - i];//example: arr[5] += arr[5-3] because you can add 3 to 2, to get 5
                    //i.e. subset {2} becomes {2,3}, so now there is 1 subset that sums to 5
                }
            }
            output.println(arr[target] / 2);
        }
        output.close();
    }
}

