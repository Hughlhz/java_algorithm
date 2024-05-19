import annotations.Star;

@Star("快排的实现代码，注意可以优化，例如选取pivot时，可以随机或者三者取中")
public class QuickSort {
    int [] nums;
    public int[] sortArray(int[] nums) {
        quicksort(nums,0, nums.length - 1);
        return nums;
    }

    private void quicksort1(int left, int right) {
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
        quicksort1(oldLeft, left - 1);
        quicksort1(left + 1, oldRight);

    }
    private void quicksort(int []arr,int left, int right) {
        if(left>=right) return;
        int tar=arr[left+(int)(Math.random()*(right-left+1))];
        int [] border=partition(arr,tar,left,right);
        quicksort(arr, left, border[0]-1);
        quicksort(arr, border[1]+1, right);
    }

    private int[] partition(int[] arr, int tar,int left,int right) {
        int less=left;
        int more=right;
        int index=left;
        while (index<=more){
            if(arr[index]<tar){
                swap(arr, less++, index++);
            }else if(arr[index]==tar){
                index++;
            }else {
                swap(arr, index, more--);
            }
        }
        return new int[]{less, more};
    }

    private void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i]=temp;
    }


    //荷兰国旗升级版本



}
