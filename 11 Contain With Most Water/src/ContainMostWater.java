/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class ContainMostWater {
    public int maxArea(int[] height) {
        int his=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int low = (height[j]<height[i])? height[j] : height[i];
                his = Math.max(his,low*(j-i));
            }
        }
        return his;
    }
    
    public static void main(String[] args){
        ContainMostWater cw = new ContainMostWater();
        int[] height = {1,1};
        cw.maxArea(height);

    }
}
