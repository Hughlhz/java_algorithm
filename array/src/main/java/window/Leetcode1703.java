package window;

import org.junit.experimental.max.MaxHistory;

import java.util.ArrayList;

public class Leetcode1703 {
    public int minMoves(int[] nums, int k) {
        ArrayList<Integer> location = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                location.add(i);
            }
        }
        int front=0;
        int back=k-1;
        int sumLocation=location.stream().limit(k).mapToInt(Integer::intValue).sum();
        int min=sumLocation-k*(k-1)/2;

        for (int i = 0; i < nums.length - k; i++) {
            int sum=k*i+k*(k-1)/2;
            min = Math.min(min, sumLocation - sum);

        }
        return 0;
    }

    public int minMovesN(int[] nums) {
        ArrayList<Integer> location = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                location.add(i);
            }
        }
        int k=location.size();
        int sumLocation=location.stream().limit(k).mapToInt(Integer::intValue).sum();
        int min= Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - k; i++) {
//            int sum=k*i+k*(k-1)/2;
//            min = Math.min(min, Math.abs(sumLocation - sum));
            int sum=0;
            for (int j = 0; j < k; j++) {
                sum += Math.abs(i + j - location.get(j));
            }
            min = Math.min(min, sum);

        }
        System.out.println(min);
        System.out.println("-----");
        return min;
    }
}
