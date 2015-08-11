/*
TASK: money
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.util.Arrays;
public class money {
    static int V,N;
    static long[][] dp;
    static int[] arr;
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "money";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        V = nextInt();N = nextInt();
        arr = new int[V];
        for (int i = 0; i < V; i++)
            arr[i] = nextInt();
        dp = new long[V+1][N+1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] =-1;
        output.println(rec(V-1, N));
        output.close();
    }
    static long rec(int m, int n){
        if(m<0 || n<0) return 0;
        if(n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        dp[m][n] = rec(m - 1, n)+rec(m, n - arr[m]);
        return dp[m][n];
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

