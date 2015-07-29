/*
TASK: subset
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.lang.Math;


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
        if(totalSum % 2 != 0)
            output.println(0);
        else{
            int target = totalSum/2;
            long[] arr = new long[target+1];
            arr[0] = 1;
            int currentSum = 0;
            for (int i = 1; i <= n; i++)
            {
                currentSum += i;
                for (int j = Math.min(target, currentSum); j >= i; j--)
                    arr[j] += arr[j - i];
            }
            output.println(arr[target]/2);
        }
        output.close();
    }
}

