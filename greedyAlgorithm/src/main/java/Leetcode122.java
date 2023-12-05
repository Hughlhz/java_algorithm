public class Leetcode122 {
    public int maxProfit(int[] prices) {
        int result=0;
        for (int i = 0; i < prices.length; i++) {
            if(i<prices.length-1&&prices[i]<prices[i+1]){
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
