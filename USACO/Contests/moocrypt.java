import java.io.*;
import java.io.StreamTokenizer;
import java.util.HashMap;


public class moocrypt {
    static int n,m;
    static StreamTokenizer input;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "moocrypt";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        n=next(), m=next();
        HashMap<String, Integer> grid = new HashMap<String, Integer>();


        output.println();
        output.close();

    }
    static int next() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

