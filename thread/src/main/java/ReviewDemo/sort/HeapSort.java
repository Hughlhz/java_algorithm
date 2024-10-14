package ReviewDemo.sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int size=arr.length;
        for (int i = arr.length/2; i >=0 ; i--) {
            heaplify(arr,i,size);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr, 0, i);
            heaplify(arr,0,--size);
        }

    }

    private static void heaplify(int[] arr, int index,int size) {
        int left=index*2+1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest==index) break;
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
