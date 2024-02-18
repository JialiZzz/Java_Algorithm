/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;
import java.util.function.Function;

/**
 *
 * @author 15469
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int k = nums[i];
                nums[i] = nums[index];
                nums[index] = k;
                index++;
            }
        }
        return index;
    }
    
    public static void main(String[] args){
        RemoveElement re = new RemoveElement();
        int mun[] = {1,2,3,4,5,6,6,7,8};
        re.removeElement(mun, 6);
        for(int k: mun){
            System.out.print(k+" ");
        }




        int n=100,sum=0;
        for( int i = 1; i <= n; i++ )
            for( int j = 1; j <= i * i; j++ )
                if( j % i == 0 )
                    for( int k = 0; k < j; k++ )
                        sum++;



        isPrime(20);




        long startTime = System.currentTimeMillis();
        isPrime(40);

        long endTime = System.currentTimeMillis();

        // 计算运行时间（毫秒）
        long executionTime = endTime - startTime;
        System.out.println("代码运行时间：" + executionTime + " 毫秒");

    }


    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    static double findRoot(Function<Double, Double> F, double low, double high, double tolerance, int maxIterations) {
        double mid;

        for (int i = 0; i < maxIterations; i++) {
            mid = (low + high) / 2;

            double fMid = F.apply(mid);

            if (Math.abs(fMid) < tolerance) {
                return mid;
            }

            if (fMid * F.apply(low) < 0) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (low + high) / 2;
    }

    private boolean findMa(int[] arr){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int tar = arr.length/2;
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else {
                hm.put(arr[i],1);
            }
            if(hm.get(arr[i])>tar){
                return true;
            }
        }
        return false;

    }


    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    static void sieve(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        System.out.print("< " + N + "： ");
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }


//    //Quadratic maximum contiguous subsequence sum algorithm
//    //seqStart and seqEnd represent the actual best sequence.
//    public static int maxSubsequenceSum( int [ ] a )
//    {
//        int maxSum = 0;
//
//        for( int i = 0; i < a.length; i++ )
//        {
//            int thisSum = 0;
//
//            for( int j = i; j < a.length; j++ )
//            {
//                thisSum += a[ j ];
//
//                if( thisSum > maxSum )
//                {
//                    maxSum = thisSum;
//                    seqStart = i;
//                    seqEnd = j;
//                }
//            }
//        }
//
//        return maxSum;
//    }
}








