public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num = new int[len1+len2];
        int i=0;
        int j=0;
        int k=0;
        while(i<len1||j<len2){
            if(i>=len1){
                for(int s=j;s<len2;s++){
                    num[k]=nums2[s];
                    k++;
                }
                break;
            }
            if(j>=len2){
                for(int s=i;s<len1;s++){
                    num[k]=nums1[s];
                    k++;
                }
                break;
            }

            if(nums1[i]<nums2[j]){
                num[k]=nums1[i];
                i++;
                k++;
            }
            else{
                num[k]=nums2[j];
                j++;
                k++;
            }
        }
        for(int s=0;s<num.length;s++){
            System.out.print(num[s]+" ");
        }
        int middle = (num.length-1)/2;
        int middle2 = (num.length-1)%2;
        double result=0;
        if(middle2==0){
            result=(num[middle2]+num[middle])/2;
        }
        else{
            result=num[middle];
        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args){
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        findMedianSortedArrays(num1,num2);
    }
}
