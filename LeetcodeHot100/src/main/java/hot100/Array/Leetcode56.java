package hot100.Array;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        int l=0;
        int r=1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        while(r<intervals.length){
            if(intervals[r][0]>intervals[l][1]){
                //不合并
                l++;
                intervals[l][0]=intervals[r][0];
                intervals[l][1]=intervals[r++][1];
                continue;
            }
            else if(intervals[r][0]<=intervals[l][1]){
                //合并
                intervals[l][0]=Math.min(intervals[r][0],intervals[l][0]);
                intervals[l][1]=Math.max(intervals[r][1],intervals[l][1]);
                r++;
            }
        }
        return getSub(intervals,l+1);
    }

    private int[][] getSub(int[][] intervals, int l) {
        int[][] sub = new int[l][];
        for (int i = 0; i < l; i++) {
            sub[i] = intervals[i];
        }
        return sub;
    }

    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        leetcode56.merge(new int[][]{{2, 3}, {4, 5}, {6, 7},{8,9},{1,10}});
    }


}
