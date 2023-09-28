package algorithms;

import common.Utils;

public class Sort {
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


}
