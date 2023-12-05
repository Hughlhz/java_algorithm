public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int range = 0;
        //代码简化==>
//        for (int i = 0; i < nums.length; i++) {
//            if (i > range) {
//                break;
//            }
        for(int i=0;i<=range;i++){
            range = Math.max(range, i + nums[i]);
            if (range >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }




    public boolean canJump_(int[] nums) {
        boolean flag=true;
        if (nums.length == 1) {
            return flag;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0||i==nums.length-1) {
                continue;
            }
            int j=i-1;
            flag=false;
            while (j >= 0 && i-j >= nums[j]) {
                j--;
            }
            if (j >= 0 && i - j < nums[j]) {
                flag = true;
            } else {
                flag=false;
                return flag;
            }
        }
        return flag;
    }
}
