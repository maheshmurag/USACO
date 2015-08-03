import java.io.*;
import java.io.StreamTokenizer;
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class moocrypt {
    static int n,m;
    static Scanner input;
    static char[][] grid;
    static HashMap<String, Integer> moo;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "moocrypt";
        input =new Scanner(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        n=next();m=next();
        grid = new char[n][m];
        moo = new HashMap<String, Integer>();
        String str = "";
        for (int i = 0; i < n; i++) {
            str = nextStr();
            grid[i] = str.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i>=2&&j>=2){//tl
                    str = comb(i,j,i-1,j-1,i-2,j-2);
                    f(str);
                }
                if(i>=2){//t
                    str = comb(i,j,i-1,j,i-2,j);
                    f(str);
                }
                if(i>=2&&j<m-2){//tr
                    str = comb(i,j,i-1,j+1,i-2,j+2);
                    f(str);
                }
                if(j>=2){//l
                    str = comb(i,j,i,j-1,i,j-2);
                    f(str);
                }
                if(j<m-2){//r
                    str = comb(i,j,i,j+1,i,j+2);
                    f(str);
                }
                if(i<n-2&&j>=2){//bl
                    str = comb(i,j,i+1,j-1,i+2,j-2);
                    f(str);
                }
                if(i<n-2){//b
                    str = comb(i,j,i+1,j,i+2,j);
                    f(str);
                }
                if(i<n-2&&j<m-2){//br
                    str = comb(i,j,i+1,j+1,i+2,j+2);
                    f(str);
                }
            }
        }
        int max=0;
        Integer[] result = new Integer[moo.size()];
        moo.values().toArray(result);
        for (int i = 0; i < result.length; i++)
            if(result[i].intValue()>max)max=result[i].intValue();
        System.out.println(moo.toString());
        output.println(max);
        output.close();

    }
    static String comb(int i1, int i2, int j1, int j2, int k1, int k2){
        return "" + grid[i1][i2] + "" + grid[j1][j2] + "" + grid[k1][k2];
    }
    static boolean isMoo(String str){
        return (str.charAt(1)==str.charAt(2) && str.charAt(1)!=str.charAt(0)&&str.charAt(1)!='O'&&str.charAt(0)!='M');
    }
    static void f(String str){
        if(isMoo(str)){
            int a = 0;
            if(moo.containsKey(str)) {
                a = moo.get(str);
            }
            moo.put(str, a+1);
        }
    }
    static int next() throws IOException {
//        input.nextToken();
        return input.nextInt();
    }
    static String nextStr() throws IOException {
//        input.nextToken();
        return input.next();
    }
}

