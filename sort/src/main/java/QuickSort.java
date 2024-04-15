import annotations.Star;

@Star("快排的实现代码，注意可以优化，例如选取pivot时，可以随机或者三者取中")
public class QuickSort {
    int [] nums;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        quicksort(0, nums.length - 1);
        return nums;
    }

    private void quicksort(int left, int right) {
        if (left >= right) {
            return;
        }
        int oldLeft=left;
        int oldRight = right;
        //记录最左侧的元素下表
        int pivot = nums[left];
        while (left < right) {
            //从right开始找第一个小于pivot的元素
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            //找到后，放到left的指向
            nums[left++] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right--] = nums[left];
        }
        nums[left] = pivot;
        quicksort(oldLeft, left - 1);
        quicksort(left + 1, oldRight);

    }


}
