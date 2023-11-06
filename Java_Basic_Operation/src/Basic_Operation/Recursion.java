package Basic_Operation;

import java.util.HashMap;

public class Recursion {

    public int getWinner(int[] arr, int k) {
        //compare and put smaller in the back
        //count the winning after k round
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer s : arr){
            map.put(s,0);
        }
        int h=arr[0];
        while(map.get(h)<k){
            int val1=arr[0];
            int val2=arr[1];
            int g = Math.max(val1,val2);
            map.put(g,map.get(g)+1);
            h=(map.get(g)>map.get(h))?g:h;
            if(val1<val2){
                for (int f=0;f<arr.length-1;f++){
                    int s=arr[f];
                    arr[f]=arr[f+1];
                    arr[f+1]=s;
                }
            }else{
                for (int f=1;f<arr.length-1;f++){
                int s=arr[f];
                arr[f]=arr[f+1];
                arr[f+1]=s;
                }
            }

            for (int i=1;i<arr.length;i++){
                System.out.print(arr[i]);
            }
            System.out.println("");
        }
        return h;
    }


    public static int sum(int k){
        if(k<0)
            return 0;
        return k+sum(k-1);
    }

    public static int sum(int start,int end){
        if(end<=start)
            return start;
        return end+sum(start,end-1);
    }



    public static void main(String[] args){
        System.out.println(sum(10));
        System.out.println(sum(10,12));
        Recursion re = new Recursion();
        int[] arr = {2,1,3,5,4,6,7};
        System.out.println(re.getWinner(arr,2));
    }
}
