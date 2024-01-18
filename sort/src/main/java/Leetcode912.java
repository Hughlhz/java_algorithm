public class Leetcode912 {
    int nums[];
    public int[] sortArray(int[] nums) {
        this.nums=nums;
        quickSort(0,nums.length-1);
        return  this.nums;
    }

    public void quickSort(int left, int right) {
        if (left == right) {
            return;
        }
        int old_left=left;
        int old_right=right;
        int pivot = nums[left];
        int temp;
        while (left < right) {
            while (left<right&&nums[right] > pivot) {
                right--;
            }
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right]=temp;
            while (left<right&&nums[left] < pivot) {
                left++;
            }
            temp = nums[right];
            nums[right--] = nums[left];
            nums[left]=temp;
        }
        quickSort(old_left, left - 1);
        quickSort(right + 1, old_right);
    }
}


