import java.lang.Integer;
import java.util.ArrayList;

public class Maximum_Decreasing_Subsequence{
    public static void main(String[] args){
        //from http://train.usaco.org/usacotext2?a=IlchiKxkPYK&S=dp
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
//        int best[] = new int[arr.length];
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(1);
//        best[0] = 1;
        int c = 0;
        for (int i = n-1-1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(b.get(b.size()-1) < arr[j]){
//                    best[++c] = arr[j];
                    b.add(arr[j]);
                }
                else if(arr[j] > b.get(b.size()-2)){
//                    arr[c] = arr[j];
                    b.set(b.size()-1, arr[j]);
                }
            }
        }
        System.out.println(b.size());
    }
}