/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

import java.util.Stack;

/**
 *
 * @author 15469
 */
public class Stack_Basic {
    private Stack<Integer> stack;
    
    private void basic_Operation(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 弹出栈顶元素
        int poppedElement = stack.pop();
        System.out.println("弹出的元素：" + poppedElement); // 输出 3

        // 查看栈顶元素
        int topElement = stack.peek();
        System.out.println("栈顶元素：" + topElement); // 输出 2

        // 判断栈是否为空
        boolean isEmpty = stack.isEmpty();
        System.out.println("栈是否为空：" + isEmpty); // 输出 false

        // 获取栈的大小
        int size = stack.size();
        System.out.println("栈的大小：" + size); // 输出 2
    }
    
    
}
