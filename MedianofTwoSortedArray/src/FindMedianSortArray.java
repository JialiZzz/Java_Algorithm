/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class FindMedianSortArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num = new int[len1+len2];
        int i=0;
        int j=0;
        int k=0;
        int d1=10000,d2=10000;
        while(i<len1||j<len2){
            if(i<len1){
                d1=nums1[i];
            }else{
                d1=10000;
            }
            if(j<len2){
                d2=nums2[j];
            }else{
                d2=10000;
            }
            //compare
            if(d1<d2){
                num[k] = d1;
                k++;
                i++;
            }else if(d2<=d1){
                num[k] = d2;
                k++;
                j++;
            }
        }
        //middle index
        int total = num.length;
                
        for(int s : num){
            System.out.print(s);
        }
        if(total % 2 == 1){
            return (double) num[total / 2];

        }else{
            int middle1 = num[total / 2 - 1];
            int middle2 = num[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }


    }
    
    public static void main(String[] args){
        int num1[] = {1,2};
        int num2[] = {3,4};
        FindMedianSortArray fm = new FindMedianSortArray();
        double val = fm.findMedianSortedArrays(num1, num2);
        System.out.print(val);
    }
    
    
}
