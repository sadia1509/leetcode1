package algorithms;

public class Search {
    public int linearSearch(int[] arr, int target) {
        for (int i=0; i<arr.length; i++)
            if(target==arr[i]) return i;
        return -1;
    }

    public int linerSearch2D(String[][] haystack, String target) {
        for (String[] row : haystack)
            for (String elem : row)
                if(elem.equals(target)) return 1;
        return -1;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (right<left) return -1;
        int mid = (left+right)/2;
        if(arr[mid] == target) return mid;
        else if (arr[mid]<target) return binarySearch(arr, mid+1, right, target);
        else if (arr[mid]>target) return binarySearch(arr, left, mid-1, target);
        else return -1;
    }
}
