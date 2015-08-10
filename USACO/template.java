/*
TASK: template
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class template {
    static StreamTokenizer input;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "template";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));


        output.println();
        output.close();

    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

