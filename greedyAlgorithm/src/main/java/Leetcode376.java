public class Leetcode376 {
    int [] nums;
    public int wiggleMaxLength(int[] nums) {
        this.nums=nums;
        int count=1;
        int flag=0;
        if(nums.length==1) return count;
        int j=0;
        while(j<nums.length-1)
        {
            if (nums[j] < nums[j+1]) {
                flag = 1;
                break;
            }
            if(nums[j] > nums[j+1]) {
                flag = -1; break;
            }
            j++;

        }
        for (int i = 0; i < nums.length; i++) {
            int temp = findMost(flag, i);
            flag*=-1;
            if (i == temp) {
                return count;
            } else {
                count++;
                i=temp-1;
            }
        }
        return count;
    }

    public int findMost(int flag,int i) {
        if(flag==1){
            while (i < nums.length-1 &&nums[i]<=nums[i+1]) i++;
            return  i;
        }
        else if(flag==-1){
            while (i < nums.length-1 &&nums[i]>=nums[i+1]) i++;
            return  i;
        }
        return i;
    }




}
