public class FindNumberK {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length-k);
        return nums[nums.length - k];
    }

    private void quickSort(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int target = arr[l + (int) Math.random() * (r - l + 1)];
        int[] border = partition(arr, l, r, target);
        if(k<border[0]) {
            quickSort(arr, l, border[0] - 1, k);
        }
        else if(k<=border[1]) return;
        else {
            quickSort(arr, border[1] + 1, r, k);
        }

    }

    private int[] partition(int[] arr, int l, int r, int target) {
        int less=l;
        int more=r;
        int index=l;
        while (index <= more) {
            if (arr[index] < target) {
                swap(arr, less++, index++);
            } else if (arr[index] == target) {
                index++;
            }else {
                swap(arr, more--, index);
            }
        }
        return new int[]{less, more};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
