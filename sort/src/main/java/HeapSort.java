import annotations.Star;

@Star("堆排序，初始化大根堆，之后每次把堆顶元素放到末尾，末尾元素放到堆顶，并逐个对节点调整成大根堆")
public class HeapSort {


    public  void heapSort(int[] nums) {
        //找到最后一个节点的父节点
        int start = (nums.length - 1) / 2;
        //调整为大顶堆
        for (int i = start; i >= 0; i--) {
            toMaxHeap(nums,nums.length,i );
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int temp=nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            toMaxHeap(nums, i, 0);
        }
    }
    public  void toMaxHeap(int[] nums, int size, int index) {
        int left=2*index+1;
        int right=2*index+2;
        int max=index;
        if (left < size && nums[left] > nums[max]) {
            max=left;
        }
        if (right < size && nums[right] > nums[max]) {
            max=right;
        }

        if (max != index) {
            int temp = nums[index];
            nums[index] = nums[max];
            nums[max] = temp;
            toMaxHeap(nums,size,max);
        }
    }
}
