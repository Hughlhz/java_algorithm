import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if(l>=r) return;
        int mid=(l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int help[] = new int[r - l + 1];
        int left=l;
        int right = mid + 1;
        int index=0;
        while (left <= mid && right <= r) {
            if (arr[left] > arr[right]) {
                help[index++] = arr[right++];
            } else {
                help[index++] = arr[left++];
            }
        }
        while (left <= mid) {
            help[index++] = arr[left++];
        }
        while (right <= r) {
            help[index++] = arr[right++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

}

