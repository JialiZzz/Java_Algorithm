package Algorithm;

import java.util.Arrays;

public class DP {
    public static int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        if(arr.length==1||arr.length==0) return 1;
        int max=1;
        Arrays.fill(dp,1);
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]-arr[j]==difference){
                    dp[i]+=dp[j];
                    max=Math.max(max,dp[i]);
                    break;
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]);
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = {3,4,-3,-2,-4};
        int dif=-5;
        System.out.println(longestSubsequence(arr,  dif));
    }


}

