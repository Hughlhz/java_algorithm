package ReviewDemo.sort;

public class MergeSort {
    public static void mergeSort(int []arr,int l,int r) {
        if(l>=r) return;
        int mid=(r+l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int helper[]=new int[r-l+1];
        int index=0;
        int left=l;
        int right=mid+1;
        while (left<=mid&&right<=r){
            if (arr[left] < arr[right]) {
                helper[index++] = arr[left++];
            } else {
                helper[index++] = arr[right++];
            }
        }
        while (left<=mid){
            helper[index++]=arr[left++];
        }
        while (right <= r) {
            helper[index++] = arr[right++];
        }

        for (int i = 0; i < helper.length; i++) {
            arr[l+i] = helper[i];
        }
    }
}
