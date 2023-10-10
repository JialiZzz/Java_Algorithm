
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class squareSortArray {
    public int[] sortedSquares(int[] nums){
        for(int i =0;i<nums.length;i++){
             nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        
        return nums;
    }
    
    
    
}
