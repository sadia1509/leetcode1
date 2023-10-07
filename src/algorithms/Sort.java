package algorithms;

import common.Utils;

public class Sort {
    public static void bubbleSort(int [] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        } for (int k : arr) System.out.print(k + " ");
    }

    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[minIndex] > arr[j]) minIndex = j;
            Utils.swap(arr, i, minIndex);
        }
        for (int k : arr) System.out.print(k + " ");
    }
// TODO  compareTo() method for string sorting
    public void insertionSort(int[] array) {
        for(int i=1; i<array.length; i++){
            int current = array[i], j=i-1;
            while (j >=0 && array[j] > current){
                array [j+1] = array[j];
                j--;
            }
            array[j+1]=current;
        }
        for (int k:array) System.out.print(k+" ");
    }

    public static void mergeSortHelper(int [] arr, int begin, int end){
        mergeSort(arr, begin, end);
        for (int k : arr) System.out.print(k + " ");
    }
    static void mergeSort (int [] arr, int begin, int end){
        if(begin < end){
            int mid = (begin+end)/2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, begin, mid, end);
        }
    }
    static void merge(int [] arr, int begin, int mid, int end){
        int leftArrLength =  mid-begin+ 1, rightArrLength = end-mid;
//        System.out.println( begin +" "+ mid +" "+ end +" ||  "+leftArrLength + "  " + rightArrLength);
        int [] leftArr = new int[leftArrLength];
        int [] rightArr = new int [rightArrLength];
        for (int i = 0; i < leftArrLength; i++) leftArr[i] = arr[begin + i];
        for (int j = 0; j < rightArrLength; j++) rightArr[j] = arr[mid + 1 + j];
        int i=0, j=0, k=begin;
        while (i < leftArrLength && j < rightArrLength)
        {
            if(leftArr[i] <= rightArr[j])  arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }
        while (i<leftArrLength)  arr[k++] = leftArr[i++];
        while (j<rightArrLength) arr[k++] = rightArr[j++];
    }


    public void quickSortHelper(int [] arr, int begin, int end){
        quickSort(arr, begin, end);
        for (int k : arr) System.out.print(k + " ");
    }


    void quickSort(int [] arr, int begin, int end){
        if(begin < end){
            int p = partition(arr, begin, end);
            quickSort (arr, begin, p - 1);
            quickSort (arr, p + 1, end);
        }
    }


    int partition(int [] arr, int begin, int end){
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return (i + 1);
    }


}
