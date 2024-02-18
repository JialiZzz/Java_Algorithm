package Data_Type.Heap;

import java.util.PriorityQueue;

public class TopTenLargestElements {
    public static int[] findTopTenLargestElements(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(Integer num : arr){
            if(heap.size()<10){
                heap.add(num);
            }
            else{
                if(num>heap.peek()){
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        int[] nums = new int[10];
        int count=0;
        while (!heap.isEmpty()){
            nums[count]=heap.poll();
            count++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 5, 12, 7, 6, 10, 15, 4, 9, 11, 2, 14, 13};
        int[] topTenLargest = findTopTenLargestElements(arr);

        System.out.println("数组中的十大元素：");
        for (int num : topTenLargest) {
            System.out.print(num + " ");
        }
    }

}
