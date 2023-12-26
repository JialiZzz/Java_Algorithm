package Data_Type.Stack_and_Queue;

import java.util.Stack;

public class Stack_Operation {



    public static int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer>stack= new Stack<>();
        for(int i=0;i<nums.length-k+1;i++){
            if(stack.isEmpty()){
                int max=nums[i];
                int maxIndex=i;
                for(int j=i;j<i+k;j++){
                    int temp=nums[j];
                    if(max<temp){
                        maxIndex=j;
                        max=nums[j];
                    }
                }
                stack.push(maxIndex);
            }
            else{
                int prev=stack.peek();
                if(prev<i){
                    int max=nums[i];
                    int maxIndex=i;
                    for(int j=i;j<i+k;j++){
                        int temp=nums[j];
                        if(max<temp){
                            maxIndex=j;
                            max=nums[j];
                        }
                    }
                    stack.push(maxIndex);
                }
                else{
                    if(nums[prev]>nums[i+k-1]){
                        stack.push(prev);
                    }else{
                        stack.push(i+k-1);
                    }


                }


            }
        }
        int[] num = new int[nums.length-k+1];
        for(int i=num.length-1;i>=0;i--){
            num[i]=nums[stack.pop()];
        }
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        return num;
    }

    public static void main(String[] args){
//        Stack<String> stack = new Stack<>();
//        Stack<String> stack1 = new Stack<>();
//        stack.push("123");
//        stack.push("1234");
//        stack1.push(stack.pop());
//        stack.peek();  //look at the top
//        System.out.println(stack1);
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k=3;
        maxSlidingWindow(nums, k);
    }

}
