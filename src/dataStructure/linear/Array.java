package dataStructure.linear;

import algorithms.Sort;
import common.Utils;

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
            if (arr[i] % 2 == 0) Utils.swap(arr, j++, i);
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
    public void printLeftRotation(int[] arr, int k) {
        for (int i : arr) {
            k %= arr.length;
            System.out.print(arr[k++] + " ");
        }
    }

    //Sort an array in wave form
    public void sortWave(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2)
            Utils.swap(arr, i, i + 1);
        for (int k : arr) System.out.print(k + " ");
    }

    //Count the number of possible triangles
    public void triangleCounter(int[] arr) {
        Arrays.sort(arr);
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                for (int k = j + 1; k < arr.length; k++)
                    if (arr[i] + arr[j] > arr[k]) counter++;
        System.out.println("The number of possible triangles is: " + counter);
    }

    //Print All Distinct Elements of a given integer array
    public void distinctElement(int[] arr) {
        for (int i = 0, j; i < arr.length; i++) {
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j]) break;
            if (i == j) System.out.print(arr[i] + " ");
        }
    }

    //Find the element that appears once in Array where every other element appears twice
    public void oneTwo(int[] arr) {
        Map<Integer, Integer> tracker = new HashMap<>();
        Boolean isNotOkay = false;
        int isOneCounter = 0;
        for (int i : arr) {
            if (tracker.containsKey(i)) tracker.put(i, tracker.get(i) + 1);
            else tracker.put(i, 1);
        }
        for (int k : tracker.values()) {
            if (k == 1) isOneCounter++;
            else if (k != 2) {
                isNotOkay = true;
                break;
            }
        }
        if (isNotOkay || isOneCounter != 1) System.out.println("NG");
        else System.out.println("OK " + tracker.entrySet());

    }

    //Leaders in an array
    public void leadersInArray(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        leaders.add(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--)
            if (arr[i] > sumArr(arr, i + 1, arr.length - 1))
                leaders.add(arr[i]);
        System.out.println(leaders);
    }

    int sumArr(int[] arr, int from, int to) {
        int total = 0;
        while (from <= to) total += arr[from++];
        return total;
    }

    //Find sub-array with given sum
    public void subArray(int[] arr, int sum) {
        int i = 0, j = 0, tempSum = 0, flag = 0;
        while (i < arr.length) {
            if (tempSum == sum) break;
            if (tempSum < sum) {
                tempSum += arr[i++];
            }
            if (tempSum > sum) {
                tempSum -= arr[j++];
                i--;
            }
            flag++;
        }
        flag = flag - j;
        System.out.println(tempSum + " || " + j + " " + flag);
    }

    /* **************MEDIUM************** */

    //Rearrange an array such that arr[i] = i
    public void rearrange(int[] arr) {
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < arr.length && arr[i] != -1) Utils.swap(arr, i, arr[i]);
            }
        }
        for (int k : arr) System.out.print(k + " ");
    }

    //Rearrange positive and negative numbers in O(n) time and O(1) extra space
    public void rearrangePosNeg(int[] arr) {
        // TODO
        for (int k : arr) System.out.print(k + " ");
    }

    //Reorder an array according to given indexes
    public void reorderingTheArrays(int[] arr, int[] index) {
        for (int i = 0; i < index.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < index.length; j++)
                if (index[j] < index[minIndex]) minIndex = j;

            Utils.swap(index, i, minIndex);
            Utils.swap(arr, i, minIndex);
        }
        for (int k : index) System.out.print(k + " ");
        System.out.println();
        for (int k : arr) System.out.print(k + " ");
    }

    //Search an element in a sorted and rotated array (done)
    public void sortedInRotation(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[minIndex] > arr[i]) minIndex = i;
        System.out.println(minIndex);
    }

    //K-th Largest Sum Contiguous Subarray
    public void kthLargestSum(int[] arr, int k) {
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sumList.add(sum);
            }
        }
        Collections.sort(sumList, Collections.reverseOrder());
        System.out.println(sumList.get(k - 1));
    }

    //Find the smallest missing number
    public void smallestMissingNumber(int[] arr, int n, int m) {
        boolean anothercase = true;
        for (int i = 0, j = 0; i < n; i++) {
            if (arr[i] != j) {
                System.out.println(j);
                anothercase = false;
                break;
            }
            j++;
        }
        if (anothercase && (arr[arr.length - 1] + 1) <= m)
            System.out.println(arr[arr.length - 1] + 1);
    }

    //Difference Array | Range update query in O(1)
    public void updateArray(int[] arr, int from, int to, int by) {
        if (from >= arr.length || to >= arr.length) System.out.println("Not possible");
        else {
            for (int i = 0; i < arr.length; i++) {
                if (i == from)
                    while (from <= to)
                        arr[from++] = by + arr[i++];
            }
            for (int k : arr) System.out.print(k + " ");
        }
    }

    //Maximum profit by buying and selling a share at most twice
    public void profitArray(int[] arr) {
        int buy1, profit1, buy2, profit2;
        buy1 = buy2 = Integer.MAX_VALUE;
        profit1 = profit2 = 0;
        for (int i = 0; i < arr.length; i++) {
            buy1 = Math.min(buy1, arr[i]);
            profit1 = Math.max(profit1, arr[i] - buy1);
            buy2 = Math.min(buy2, arr[i] - profit1);
            profit2 = Math.max(profit2, arr[i] - buy2);
        }
        System.out.println(profit2);
    }

    //Smallest subarray with sum greater than a given value
    public void smallestSubarray(int[] arr, int k) {
        List<Integer> sumList = new ArrayList<>();
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i, count = 0; j < arr.length; j++) {
                sum += arr[j];
                sumList.add(sum);
                count++;
                if (sum > k) minCount = Math.min(minCount, count);
            }
        }
        if (minCount == Integer.MAX_VALUE) System.out.println("Not Possible");
        else System.out.println(minCount);
    }

    //Inversion count in Array using Merge Sort
    public void inversionCount(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j]) counter++;
        System.out.println(counter);
    }

    //Sort an array of 0s, 1s and 2s
    public void sortZeroOneTwo(int[] arr) {
        int[] trackerArray = new int[3];
        for (int i = 0; i < arr.length; i++)  trackerArray[arr[i]]++;
        for (int j = 0; j < trackerArray.length; j++)
            for (int k = 0; k < trackerArray[j]; k++)
                System.out.print(j + " ");
    }

    //Merge two sorted arrays with O(1) extra space
    public void mergeTwoArraysSorted(int [] arr1, int [] arr2){
        int i = 0, j = 0, k = arr1.length - 1;
        while (i <= k && j < arr1.length) {
            if (arr1[i] < arr2[j]) i++;
            else {
                int temp = arr2[j];
                arr2[j++] = arr1[k];
                arr1[k--] = temp;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int p : arr1) System.out.print(p + " ");
        System.out.println();
        for (int p : arr2) System.out.print(p + " ");
    }

    //Majority Element
    public void majorityElement(int [] arr){
        Map<Integer, Integer> trackerMap = new LinkedHashMap<>();
        for (int i:arr){
            if(trackerMap.containsKey(i)) trackerMap.put(i, trackerMap.get(i)+1);
            else trackerMap.put(i, 1);
            if(trackerMap.get(i) > arr.length/2) System.out.println(i);
        } //System.out.println("No Majority Element");
    }

    //Two Pointers Technique
    public void twoPointers(int [] arr, int x){
        for(int firstPointer=0; firstPointer<arr.length; firstPointer++)
            for (int lastPointer = arr.length-1; firstPointer < lastPointer; lastPointer--)
                if (arr[firstPointer] + arr[lastPointer--] == x) System.out.println(true);
    }

    //Find a peak element
    public void peakElement(int [] arr){
        for (int i=1; i<arr.length-1; i++)
            if(arr[i-1]<arr[i] && arr[i+1]<arr[i])
                System.out.println(arr[i]);
    }

    //Find a triplet that sum to a given value
    public void tripletSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int count =0;
        List<Integer> triplets = new ArrayList<>();
        for (int i=arr.length-1; i>=0; i--){
            if(arr[i] <= sum) {
                sum -= arr[i];
                triplets.add(arr[i]);
                count++;
                if(sum==0 && count<3){
                    sum += arr[i];
                    triplets.remove(--count);
                }
            }
        }
        System.out.println(triplets);
    }

    //Minimum increment by k operations to make all elements equal
    public void minIncrement(int [] arr, int k){
        int min= Integer.MAX_VALUE, sum =0;
        for (int i : arr){
            min = Math.min(min, i);
            sum += i;
        }
        // TODO : result needs to check
        System.out.println(sum - k*min);
    }

    //Equilibrium index of an array
    public void equilibriumIndex (int [] arr){
        int sumLeft=0, sumRight=0, i, j;
        for (i=0, j= arr.length-1; i<arr.length/2; i++, j--){
           sumLeft += arr[i];
           sumRight += arr[j];
        }
        if (sumLeft == sumRight) System.out.println(i);
        else System.out.println(-1);
    }
}
