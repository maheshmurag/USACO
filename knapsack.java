    import java.lang.Math;
import java.lang.String;
import java.util.Arrays;

public class knapsack{
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};//{1, 3, 4, 5};
        int[] weight = {5, 4, 6, 3};//{1, 4, 5, 7};
        int maxWeight = 10;//7;
        int[][] g = new int[weight.length][maxWeight + 1];
        for (int i = 0; i < g.length; i++)
            Arrays.fill(g[i], 0);
        for (int i = 0; i < g.length; i++) {
            for (int j = 1; j < g[0].length; j++) {
                if (i == 0 && weight[i] <= j)
                    g[i][j] = val[i];
                else if (i-1>=0 && weight[i] > j)
                    g[i][j] = g[i - 1][j];
                else if(i-1>=0)
                    g[i][j] = Math.max(val[i] + g[i - 1][j - weight[i]], g[i - 1][j]);
            }
        }
        System.out.println("Solution: " + g[g.length - 1][g[0].length - 1]);
        //retrace
        int i = g.length - 1, j = g[0].length - 1;
        String str = "";
        while (i>=0 && g[i][j] != 0) {
            if (i - 1 >= 0 && g[i][j] != g[i - 1][j]) {
                str += "item " + i + " with value " + val[i] + " and weight " + weight[i] + "\n";
                j -= weight[i];
                i -= 1;
            }
            else i--;
        }
        System.out.println(str);
    }
    static void printArr(int[][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++)
                System.out.print(g[i][j] + " ");
            System.out.println();
        }
    }
}