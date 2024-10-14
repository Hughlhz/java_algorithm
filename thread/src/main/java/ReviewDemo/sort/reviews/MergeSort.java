package ReviewDemo.sort.reviews;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int arr[]){
        sort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void sort(int[] arr, int l, int r) {
        if(l>=r) return;
        int mid=(l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr,l,mid,r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int p1=l;
        int p2=mid+1;
        int helper[]=new int[r-l+1];
        int index=0;
        while (p1<=mid&&p2<=r){
            if(arr[p1]<arr[p2]){
                helper[index++]=arr[p1++];
            }else {
                helper[index++]=arr[p2++];
            }
        }
        while (p1<=mid){
            helper[index++]=arr[p1++];
        }
        while (p2<=r){
            helper[index++]=arr[p2++];
        }
        for (int i = 0; i < helper.length; i++) {
            arr[l+i]=helper[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(new int[]{4,3,6,8,1,9,0,5});
    }
}
