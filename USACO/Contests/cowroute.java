/*
TASK: template
LANG: JAVA
ID: maheshm2
 */
import java.io.*;


public class template {
    public static void main(String[] args) throws IOException {
        String prob = "template";
        StreamTokenizer input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        input.nextToken();
        int n=(int)input.nval;
        output.println();
        output.close();

    }
}

