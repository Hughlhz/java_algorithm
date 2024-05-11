package hot100.dynamic;

public class Leetcode700 {

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                result[i]+=result[j]*result[i-1-j];
            }
        }
        return result[n];
    }
}
