
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
    public String longestPalindrome(String s) {
        //two pointer   hashmap
        String his="",curr="";
        int i=0;
        for(int k=0;k<s.length();k++){
            i=k;
            curr="";
            while(i<s.length()){
                curr+=s.charAt(i);
                if(isPalindrome(curr)){
                    his = (his.length()>curr.length()) ? his:curr;
                }
                i++;
            }

        }
        return his;
    }

    public boolean isPalindrome(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        String str= lp.longestPalindrome("cbbd");
        int len = str.length();
        for(int i=0;i<len;i++){
        System.out.print(str.charAt(i)+" ");
        }
    }
    
}

