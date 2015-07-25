import java.io.*;
public class meeting {
    static int N,M;
    static int[][] in;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "meeting";
        StreamTokenizer input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        input.nextToken();
        N=(int)input.nval;
        input.nextToken();
        M=(int)input.nval;

        in = new int[M][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                input.nextToken();
                in[i][j] = (int)input.nval;
            }
        }

        output.println();
        output.close();

    }
}

