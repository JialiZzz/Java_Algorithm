/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */

//Java create obj first, then use its func
//binary search

public class Binary_Search {
    public int search(int[] nums, int target){
        int mid;
        int end = nums.length-1;
        int start = 0;
        while(start<=end){
            mid = (end-start)/2+start;   // ***  
//            System.out.println("start is "+start);
//            System.out.println("mid is "+mid);
//            System.out.println("end is "+end);
            if(nums[mid]==target){
                return mid;          
            }
            if(nums[mid]>target){
                end = mid-1;          // because mid is not the value, so the next loop end value will end with mid-1
            }
            if(nums[mid]<target){
                start = mid+1;       // because mid is not the value, so the next loop end value will start with mid+1
            }
        }
        return -1;
    }
    
    public int B_S(int[] nums, int left, int right, int target){
        int mid = (right-left)/2+left;
        if(left<=right){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right = mid-1;
                return B_S(nums,left,right,target);
            }
            if(nums[mid]<target){
                left = mid+1;
                return B_S(nums,left,right,target);
            }
        }
        return -1;
    }
    
public static void main(String[] args) {
    int[] number = {1,2,3,4,5,6,7};
    int target1 = 7;
    Binary_Search obj = new Binary_Search();        //build obj first, then use its func
    int s = obj.search(number, target1);
    int k = obj.B_S(number, 0, 6, target1);
    System.out.print(k);
}

}

