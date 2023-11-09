package Data_Type.Stack_and_Queue;

import java.util.Stack;

public class Stack_Operation {


    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        stack.push("123");
        stack.push("1234");
        stack1.push(stack.pop());
        stack.peek();  //look at the top
        System.out.println(stack1);


    }

}
