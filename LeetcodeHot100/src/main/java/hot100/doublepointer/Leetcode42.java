package hot100.doublepointer;

import java.util.Enumeration;

public class Leetcode42 {
    public int trap(int[] height) {
        if(height.length<=2) return 0;


        int left=0;
        int right=1;
        int volume=0;
        int tempVolume=0;
        int tempMax=height[right];
        int maxIndex=right;
        for (; right < height.length; right++) {
            //找右壁
            //1、大于左壁右边1位的可能成为右壁
            //2、大于等于左壁的一定是右壁
            //3、所以右壁应该是大于左壁1位的最大的那个或者大于左壁的那个
            while (right<height.length) {
                if (height[right] >=tempMax) {
                    tempMax = height[right];
                    maxIndex = right;
                }

                if (tempMax >= height[left]) {
                    break;
                }
                right++;
            }
            if (left + 1 == maxIndex) {
                left=maxIndex;
                right=maxIndex+1;
                if(right>=height.length) return volume;
                tempMax = height[right];
                continue;
            }
            //右边碰壁 归位
//            if (right>= height.length) {
//                if(height[left+1]>=height[left]){
//                    left++;
//                    right = left;
//                    continue;
//                }
//
//            }
            int length=maxIndex-left-1;
            int width = Math.min(height[left], tempMax);
            if (width == 0) {
                left=maxIndex;
                if (left + 1 >= height.length) {
                    return volume;
                }
                tempMax = height[left + 1];
                continue;
            }
            tempVolume = width * length;
            for (int index = left + 1; index < maxIndex; index++) {
                tempVolume -= height[index];
            }
            volume += tempVolume;

            left=maxIndex;
            if (left + 1 >= height.length) {
                break;
            }
            tempMax = height[left + 1];
        }
        return volume;
    }
}
