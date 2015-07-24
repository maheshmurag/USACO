import java.util.Arrays;

public class Maximum_Decreasing_Subsequence {
    public static void main(String[] args) {
        //from http://train.usaco.org/usacotext2?a=IlchiKxkPYK&S=dp
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
//        int arr[] = {5, 3, 4, 8, 6, 7};
        int state[] = new int[arr.length];
        Arrays.fill(state, 1);//value at i represents longest increasing sequence up till that index
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] >= arr[j])
                    if (state[j] + 1 >= state[i]) {
                        state[i] = state[j] + 1;
                        if(state[i]>max)
                            max=state[i];
                    }
        System.out.println(max);
        System.out.println(Arrays.toString(state));
    }
}