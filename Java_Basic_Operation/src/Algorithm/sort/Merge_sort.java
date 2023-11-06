package Algorithm.sort;

public class Merge_sort {
    public static void mergeSort(int[] arr){
        int inputLength = arr.length;
        int mid = inputLength/2;
        if(inputLength<2) return;

        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[inputLength-mid];
        for(int i=0;i<mid;i++){
            leftHalf[i]=arr[i];
        }
        for(int i=mid;i<inputLength;i++){
            rightHalf[i-mid]=arr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr,leftHalf,rightHalf);
    }


    private static void merge (int[] arr, int[] leftHalf, int[] rightHalf){
        int leftSize=leftHalf.length;
        int rightSize=rightHalf.length;

        int i=0,j=0,k=0;
        while(i<leftSize&&j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
                arr[k]=leftHalf[i];
                i++;
            }else{
                arr[k]=rightHalf[j];
                j++;
            }
            k++;
        }
        while(i<leftSize){
            arr[k]=leftHalf[i];
            k++;
            i++;
        }
        while(j<rightSize){
            arr[k]=rightHalf[j];
            k++;
            j++;
        }

    }


    public static void main(String[] args){
        int[] arr = {1,3,2,7,5,8,19,12,4,6};
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


}
