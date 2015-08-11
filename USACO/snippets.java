import java.util.Arrays;

public class snippets{
    public static void main(String[] args) throws java.io.IOException {
        int[][] array = new int[5][5];
        deepFill(array, 19);
        System.out.println(Arrays.deepToString(array));
    }
    public static void deepFill(int[][] arr, int val){
        df(arr,val,0,0);
    }
    public static void df(int[][] a, int v, int i, int j){
        if(i>=a.length) return;
        if(j>=a[0].length) {
            df(a,v,i+1,0);
            return;
        }
        a[i][j] = v;
        df(a,v,i,j+1);
    }
}

