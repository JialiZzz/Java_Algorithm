public class Bag {
    public static int bag(int[]val, int[]weight,int bagSize){
        int[][] dp = new int[val.length][bagSize+1];
        //init
        for(int i=weight[0];i<bagSize+1;i++){
            dp[0][i]=val[0];
        }
        for(int i=1;i<val.length;i++){
            for(int j=weight[0];j<bagSize+1;j++){
                if(weight[i]>j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+val[i]);
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args){
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        bag(value, weight,bagSize);
    }

}
