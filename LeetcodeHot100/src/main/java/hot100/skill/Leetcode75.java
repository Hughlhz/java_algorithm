package hot100.skill;

public class Leetcode75 {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left]=0;
                left++;
            } else if (nums[i] == 2) {
                nums[right]=2;
                nums[i]=nums[right];
                right--;
            }
        }
    }
    public void sortColors_(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int i=0;
        for (; i < count[0]; i++) {
            nums[i]=0;
        }
        for (; i < count[1]+count[0]; i++) {
            nums[i]=1;
        }
        for (; i < nums.length; i++) {
            nums[i]=2;
        }
    }
}
