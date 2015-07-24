import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {
        //from http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Thing state[] = new Thing[arr.length];
        for (int i = 0; i < state.length; i++) {
            state[i] = new Thing();
        }
        int n = arr.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] - arr[j] > 0 && arr[j] - arr[state[j].indLast] < 0) || (arr[i] - arr[j] < 0 && arr[j] - arr[state[j].indLast] > 0)) {
                    if (state[j].len + 1 >= state[i].len) {
                        state[i].indLast = j;
                        state[i].len = state[j].len + 1;
                        if (state[i].len > max) {
                            max = state[i].len;
                        }
                    }
                }
            }
        }
        System.out.println(max + 1);
    }

    static class Thing {
        int len = 1;
        int indLast = 0;

        public Thing() {
            len = 1;
            indLast = 0;
        }

        public String toString() {
            return "len: " + len + " indLast: " + indLast;
        }
    }
}