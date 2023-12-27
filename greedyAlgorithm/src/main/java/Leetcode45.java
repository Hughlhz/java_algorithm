public class Leetcode45 {
    public int jump(int[] nums) {
        int range = nums[0];
        if (nums.length == 1) {
            return 0;
        }
        int[] ranges = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ranges[i] = nums[i] + i;
        }
        int count = 1;
        int temp=0;
        for (int i = 1, j = range; j < nums.length - 1; ) {
            for (; i < j+1; i++) {
                if(temp<ranges[i])temp=ranges[i];
            }
            count++;
            if (temp >= nums.length - 1) {
                return  count;
            }
            j=temp;

        }
        return count;
    }

    public boolean canJump(int[] nums) {
        int range = nums[0];

        for (int i = 0; i <= range; i++) {
            if (nums[i] + i >= range) range = nums[i] + i;
            if (range >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
