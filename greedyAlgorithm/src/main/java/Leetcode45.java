public class Leetcode45 {
    public int jump(int[] nums) {
        int range=nums[0];
        int count=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= range; j++) {
                temp = Math.max(temp, nums[i] + i);
            }
            range=temp;
            i=temp;
            count++;
        }
        return count;
    }
}
