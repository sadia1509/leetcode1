package dataStructure.linear;

import algorithms.Sort;

import java.util.*;

public class Array {
    void shiftFromZtoA(int[] arr, int from, int to) {
        while (from < to) {
            arr[from] = arr[from + 1];
            from++;
        }
    }

    //Find the largest three elements in an array
    //Find Second largest element in an array
    public void threeElements(int[] arr) {
        int first, second, third = Integer.MIN_VALUE;
        first = second = third;
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            if (elem > first) {
                third = second;
                second = first;
                first = elem;
            } else if (elem > second && elem != first) {
                third = second;
                second = elem;
            } else if (elem > third && elem != second) {
                third = elem;
            }
        }
        System.out.println("Find the largest three elements in an array: " + first + " " + second + " " + third);
        System.out.println("Find Second largest element in an array: " + second);
    }

    //Move all zeroes to end of array
    public void zeroToEnd(int[] arr) {
        int pivot = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shiftFromZtoA(arr, i, pivot);
                arr[pivot] = 0;
            }
        }
        for (int k : arr) System.out.print(k + " ");
    }

    //Rearrange array such that even positioned are greater than odd
    public void evenPositionedGreater(int[] arr) {
        Arrays.sort(arr);
        int[] arrRes = new int[arr.length];
        for (int i = 0, j = 0, k = arr.length - 1; i < arrRes.length; i++) {
            if ((i + 1) % 2 == 0) arrRes[i] = arr[k--];
            else arrRes[i] = arr[j++];
        }
        for (int k : arrRes) System.out.print(k + " ");
    }

    //Rearrange an array in maximum minimum form using Two Pointer Technique
    public void maxMinTwoPointer(int[] arr) {
        int smallPointer = 0, largePointer = arr.length - 1;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = i % 2 == 0 ? arr[largePointer--] : arr[smallPointer++];
        for (int k : newArr) System.out.print(k + " ");
    }

    //Segregate even and odd numbers
    public void segregateEvenOdd(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) Sort.swap(arr, j++, i);
        for (int k : arr) System.out.print(k + " ");
    }

    //Reversal algorithm for array rotation -> 1 2 3 4 5 6 7
    public void reversalRotation(int[] arr, int d) {
        int length = arr.length;
        d %= length; // Ensure shiftBy is within array bounds for d=4
        reverseArray(arr, 0, d - 1); // Reverse the first part -> 4 3 2 1 5 6 7
        reverseArray(arr, d, length - 1); // Reverse the second part -> 4 3 2 1 7 6 5
        reverseArray(arr, 0, length - 1); // Reverse the entire array -> 5 6 7 1 2 3 4
        for (int k : arr) System.out.print(k + " ");
    }

    void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Print left rotation of array in O(n) time and O(1) space
    public void printLeftRotation(int [] arr, int k){
        for (int i: arr){
            k %= arr.length;
            System.out.print(arr[k++] + " ");
        }
    }

    //Sort an array in wave form
    public void sortWave(int [] arr){
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i += 2)
            Sort.swap(arr, i, i+1);
        for (int k : arr) System.out.print(k + " ");
    }

    //Count the number of possible triangles
    public void triangleCounter(int [] arr){
        Arrays.sort(arr);
        int counter = 0;
        for(int i =0; i<arr.length; i++)
            for (int j=i+1; j<arr.length; j++)
                for(int k=j+1; k<arr.length; k++)
                    if(arr[i]+arr[j]>arr[k]) counter++;
        System.out.println("The number of possible triangles is: "+ counter);
    }

    //Print All Distinct Elements of a given integer array
    public void distinctElement(int[]arr){
        for (int i=0, j; i<arr.length; i++){
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j]) break;
            if (i == j) System.out.print( arr[i] + " ");
        }
    }

    //Find the element that appears once in Array where every other element appears twice
    public void oneTwo(int [] arr){
        Map<Integer, Integer> tracker = new HashMap<>();
        Boolean isNotOkay = false;
        int isOneCounter = 0;
        for (int i : arr){
            if(tracker.containsKey(i)) tracker.put(i, tracker.get(i)+1);
            else tracker.put(i,1);
        }
        for (int k : tracker.values()){
            if(k==1)   isOneCounter++;
            else if (k!=2) {
                isNotOkay = true;
                break;
            }
        }
        if(isNotOkay || isOneCounter!=1) System.out.println("NG");
        else System.out.println("OK " + tracker.entrySet());

    }

    //Leaders in an array
    public void leadersInArray(int[]arr){
        List<Integer> leaders = new ArrayList<>() ;
        leaders.add(arr[arr.length-1]);
        for(int i=arr.length-2; i>=0; i--)
            if(arr[i] > sumArr(arr, i+1, arr.length-1))
                leaders.add(arr[i]);
        System.out.println(leaders);
    }
    int sumArr(int [] arr, int from, int to){
        int total =0;
        while( from <= to ) total += arr[from++];
        return total;
    }

    //Find sub-array with given sum
    public void subArray(int[] arr, int sum){
        int i=0, j=0, tempSum =0, flag=0;
        while (i<arr.length){
            if(tempSum==sum) break;
            if (tempSum < sum) {
                tempSum += arr[i++];
            }
            if (tempSum > sum) {
                tempSum -=arr[j++];
                i--;
            }
            flag++;
        }
        flag=flag-j;
        System.out.println(tempSum + " || " +j +" " + flag);
    }
}
