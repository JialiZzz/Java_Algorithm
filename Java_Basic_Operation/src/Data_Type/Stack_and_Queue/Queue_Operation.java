package Data_Type.Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Operation {

    public static void main(String[] args){
        Queue<Object> queue = new LinkedList<>();
        queue.add(123);
        queue.poll();  //look at the top
        queue.offer(123);
        queue.remove();

    }
}
