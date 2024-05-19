import annotations.Star;

import java.util.EnumSet;

@Star("堆排序，初始化大根堆，之后每次把堆顶元素放到末尾，末尾元素放到堆顶，并逐个对节点调整成大根堆")
public class HeapSort {


    public  void heapSort(int[] nums) {
        int size = nums.length;

        //找到最后一个节点的父节点
        int start = (nums.length - 1) / 2;
        //调整为大顶堆
        for (int i = start; i >=0; i--) {
            heapify(nums,i,size);
        }
        while (size>0){
            swap(nums,0,size--);
            heapify(nums,0,size);
        }
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index=(index-1)/2;
        }
    }

    private void heapify(int[] arr, int index, int size) {
        int left=index*2+1;
        while (left < size) {
            int largest=left+1<size&&arr[left+1]>arr[left]?left+1:left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index=largest;
            left=index*2+1;
        }
    }

    private void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i]=temp;
    }

}
