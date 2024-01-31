
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class LongestPalindrome {
    class Solution {
        public static String longestPalindrome(String s) {
            //
            int l=0;
            int r=0;
            if(s.length()==1) return s;
            boolean[][] dp =new boolean[s.length()][s.length()];

            for(int i=0;i<s.length();i++){
                dp[i][i]=true;
            }

            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<s.length();j++){
                    if(j==i+1){
                        if(s.charAt(i)==s.charAt(j)){
                            dp[i][j]=true;
                            if(r-l+1<j-i+1){
                                l=i;
                                r=j;
                                System.out.print("left is "+i);
                                System.out.print(" right is "+j);
                                System.out.println();
                            }
                        }
                        else{
                            dp[i][j]=false;
                        }
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                        if(dp[i][j]){
                            if(r-l+1<=j-i+1){
                                l=i;
                                r=j;
                                System.out.print("left is "+i);
                                System.out.print(" right is "+j);
                                System.out.println();
                            }
                        }
                    }

                }
            }
            StringBuilder res = new StringBuilder();
            for(int i=l;i<=r;i++){
                res.append(s.charAt(i));

            }
            return res.toString();

        }
    }
    
    
    public static void main(String[] args){
        Solution.longestPalindrome("aaaa");
    }
    
}

