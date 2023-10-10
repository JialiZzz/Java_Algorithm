/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    
  public static void main(String[] args) {
        removeElement k2 = new removeElement();
    int[] number = {3,2,2,3};
    int target1 = 3;
    int k = k2.removeElement(number,target1);
    System.out.println(k);
    for(int i=0;i<number.length;i++){
        System.out.print(number[i]+" ");
    }
    
}
}
