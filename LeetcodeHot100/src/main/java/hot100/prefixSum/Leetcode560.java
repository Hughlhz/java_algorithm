package hot100.prefixSum;

import javax.swing.*;
import java.util.HashMap;

public class Leetcode560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        //使用前缀和，任意两个前缀和的差值就表示某子数组的和，因此，用一个map存前缀和，有重复的前缀和也没关系，计数加1即可
        prefixMap.put(0, 1);//表示0个数相加为0，有一种情况
        int sum=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += prefixMap.getOrDefault(sum - k,0);
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }




        //双指针做法
    public int subarraySumDoublePointer(int[] nums, int k) {
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return  result;
    }
}
