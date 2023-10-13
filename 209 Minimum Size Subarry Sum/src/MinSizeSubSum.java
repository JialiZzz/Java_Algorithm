
import static java.lang.Math.min;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class MinSizeSubSum {
    public int minSubArrayLen(int target, int[] nums) {
        int his = 999;
        his = min(his,999);
        for(int i = 0; i<nums.length; i++){
            int s = 0;
            int new1 = target-nums[i];
            if(new1<=0){return 1;}
            if(new1>0){
                s++;
                for(int k = i+1; k<nums.length; k++){
                    new1 -= nums[k];
                    s++;
                    if(new1<=0){
                        if(his>s){
                            his=s;
                        }
                    }
                }
            }
        }
        if(his==999){return 0;}
        return his;
    }
    
    public static void main(String[] args){
        
    }
}
