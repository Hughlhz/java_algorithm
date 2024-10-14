package hot100.heap;

public class Leetcode215 {
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            quickSortForK(nums, 0, nums.length - 1, k);
            return nums[nums.length - k];
        }

        private void quickSortForK(int[] nums, int l, int r, int k) {
            if(l>=r) {
                return;
            }
            int tar = nums[l + (int) ((r - l) * Math.random())];
            int[] border = partition(nums, l, r, tar);
            if(nums.length-k<border[0]){
                quickSortForK(nums, l, border[0] - 1, k);
            }else if(nums.length-k>border[1]){
                quickSortForK(nums, border[1] + 1, r, k);
            }
        }

        private int[] partition(int[] nums, int l, int r, int tar) {
            int less=l;
            int more=r;
            int index=l;
            while (index <= more) {
                if (nums[index] < tar) {
                    swap(nums, index++, less++);
                }else if(nums[index]>tar){
                    swap(nums, more--, index);
                }else{
                    index++;
                }
            }
            return new int[]{less, more};
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int lastParent=nums.length/2-1;
            int size = nums.length;
            for (int i = lastParent; i >= 0; i--) {
                heaplify(nums, i, size);
            }

            for (int i = 0; i < k; i++) {
                swap(nums, 0, --size);
                heaplify(nums, 0, size);
            }
            return nums[nums.length - k];

        }

        public void heaplify(int[] arr, int index, int size) {
            int left=index*2+1;
            while (left < size) {
                int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
                largest=arr[largest]>arr[index]?largest:index;
                if(largest==index){
                    break;
                }
                swap(arr, largest, index);
                index=largest;
                left=2*index+1;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
