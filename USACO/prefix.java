/*
TASK: prefix
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.lang.StringBuilder;
import java.util.*;
public class prefix {
    public static void main(String[] args) throws java.io.IOException {
        String prob = "prefix";
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        String s = "";
        BufferedReader bf = new BufferedReader(new FileReader(prob + ".in"));
        ArrayList<String> prefixes = new ArrayList<String>();
        String line = bf.readLine();
        while (!line.equals(".")) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens())
                prefixes.add(st.nextToken());
            line = bf.readLine();
        }
        StringBuilder sb = new StringBuilder();
        line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
        }
        String S = sb.toString();
        boolean dp[] = new boolean[S.length() + 1];
        dp[0] = true;
        for (int i = 0; i < prefixes.size(); i++)
            if (S.substring(0, prefixes.get(i).length()).equals(prefixes.get(i)))
                dp[prefixes.get(i).length()] = true;
        for (int i = 0; i < S.length(); i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < prefixes.size(); j++) {
                int len = prefixes.get(j).length();
                if (i + len <= S.length() && S.substring(i, i + len).equals(prefixes.get(j)))
                    dp[i + len] = true;
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != false) {
                output.println(i);
                break;
            }
        }
        output.close();
    }
}

