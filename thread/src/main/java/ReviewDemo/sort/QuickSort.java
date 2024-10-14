package ReviewDemo.sort;

public class QuickSort {
    public static void  quickSort(int[] arr, int l, int r){
        if(l>=r) return;
        int tar=arr[l+ (int) (Math.random() * (r - l+1))];//注意这里是r-l+1
        int[] border=quickSortPartion(arr,tar,l,r);
        quickSort(arr,l,border[0]-1);
        quickSort(arr,border[1]+1,r);
    }

    private static int[] quickSortPartion(int[] arr, int tar, int l, int r) {
        int less=l;
        int more=r;
        int cur=l;
        while (cur<=more){//注意这里的条件是小于等于大区的下标
            if(arr[cur]>tar){
                swap(arr,cur,more--);
            }else if(arr[cur]==tar){
                cur++;
            }else{
                swap(arr,cur++,less++);
            }
        }
        return new int[]{less,more};

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
