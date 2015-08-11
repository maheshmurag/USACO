/*
TASK: money
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.util.Arrays;
public class money {
    static int V,N;
    static long[] nways;
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "money";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        V = nextInt();N = nextInt();
        nways = new long[N+1];
        nways[0] = 1;
        for (int i = 0; i < V; i++) {
            int x = nextInt();
            for (int j = x; j <= N; j++)
                nways[j] += nways[j-x];
        }
        output.println(nways[N]);
        output.close();
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

