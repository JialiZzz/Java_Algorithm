package Algorithm.search;

public class Binary_Search {
    public static int binary_search(int[] arr, int number,int left , int right){
        if(left<=right){
            int middle = (left+right)/2;
            int midVal = arr[middle];
            if(midVal==number) return middle;
            else if(midVal>number){
                return binary_search(arr, number, left , middle-1);
            }else if(midVal<number){
                return binary_search(arr, number, middle+1 , right);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,2,7,8,9,10};

        int k =binary_search(arr,10,0,arr.length-1);
        System.out.println(k);
    }

}
