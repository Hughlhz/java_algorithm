package hot100.dynamic.reviews;

import java.util.Scanner;

public class Kama52 {
    public static void main (String[] args) {
        Scanner in=new Scanner(System.in);
        String param[]=in.nextLine().split(" ");
        int n=Integer.valueOf(param[0]);
        int v=Integer.valueOf(param[1]);
        int[] weights=new int[n];
        int[] values=new int[n];
        int index=0;
        while(index<n){
            String param1[]=in.nextLine().split(" ");
            weights[index]=Integer.valueOf(param1[0]);
            values[index]=Integer.valueOf(param1[1]);
            index++;
        }
        int []dp=new int[v+1];
        dp[weights[0]]=values[0];
        for(int j=0;j<n;j++){
            for(int i=0;i<v+1;i++){
                if(i-weights[j]>=0)
                    dp[i]=Math.max(dp[i-weights[j]]+values[j],dp[i]);
            }
        }
        System.out.println(dp[n]);

    }
}
