package Algorithm.sort;

import java.util.Random;

public class Quick_sort {


    public static void quickSort(int[] arr){
        quickSort( arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low>=high) return;
        int pivotIndex = new Random().nextInt(high-low)+low;
        swap(arr,pivotIndex,high);
        int pivot = arr[high];
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer<rightPointer){
            while(arr[leftPointer]<=pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (arr[rightPointer]>=pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(arr,leftPointer,rightPointer);

        }
        swap(arr,leftPointer,high);
        quickSort(arr,low,leftPointer-1);
        quickSort(arr,leftPointer+1,high);
    }

    private static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }


    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void main(String args[]){
        Random rand = new Random();
        int[] number = new int[500];
        for(int i=0;i<number.length;i++){
            number[i]=rand.nextInt(1000);
        }
        quickSort(number);
        printArray(number);
    }

}
