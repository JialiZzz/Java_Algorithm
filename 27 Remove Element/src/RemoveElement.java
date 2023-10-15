/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int k = nums[i];
                nums[i] = nums[index];
                nums[index] = k;
                index++;
            }
        }
        return index;
    }
    
    public static void main(String[] args){
        RemoveElement re = new RemoveElement();
        int mun[] = {1,2,3,4,5,6,6,7,8};
        re.removeElement(mun, 6);
        for(int k: mun){
            System.out.print(k+" ");
        }
    }
}
