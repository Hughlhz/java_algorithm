package hot100.dynamic.reviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kama46 {
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] param=br.readLine().split(" ");
        int m=Integer.valueOf(param[0]);
        int n=Integer.valueOf(param[1]);
        Integer[] weights= Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] values=Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int dp[]=new int[n+1];
        for(int i=weights[0];i<n+1;i++){
            dp[i]=values[0];
        }
        for(int i=1;i<m;i++){
            for(int j=n;j>=0;j--){
                if(j-weights[i]>=0)
                    dp[j]=Math.max(dp[j-weights[i]]+values[i],dp[j]);

            }
        }
        System.out.println(dp[n]);
    }
}
