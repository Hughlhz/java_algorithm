package ReviewDemo.sort.reviews;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(new int[]{4,3,6,8,1,9,0,5});
    }
    public void quickSort(int[]arr){
        sort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void sort(int[] arr, int l, int r) {
        if(l>=r) return;
        int pivot=arr[(int)Math.random()*(r-l+1)+l];
        int[] border = partion(arr,pivot,l,r);
        sort(arr,l,border[0]-1);
        sort(arr,border[1]+1,r);
    }

    private int[] partion(int[] arr, int pivot,int l, int r) {
        int less=l;
        int more=r;
        int cur=l;
        while (cur<=more){
            if(arr[cur]==pivot){
                cur++;
            }else if(arr[cur]<pivot){
                swap(arr,less++,cur++);
            }else{
                swap(arr,cur,more--);
            }
        }
        return new int[]{less,more};
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
