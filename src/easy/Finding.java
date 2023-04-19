package easy;

public class Finding {
    public int strStr(String haystack, String needle) {
        return  haystack.indexOf(needle);
    }

    int binarySearch(int [] nums, int target, int start, int end){
        int mid = (start+end)/2;
        if(nums[mid]==target || start > end) return mid;
        else{
            if(nums[mid] > target) return binarySearch(nums, target, start, mid-1);
            else  return binarySearch(nums, target, mid+1, end);
        }
    }
    public int searchInsert(int[] nums, int target) {
       int index = binarySearch(nums, target, 0, nums.length-1);
        //System.out.println(nums[index] +" "+ target);
       if (nums[index]==target || nums[index] > target)  return index ;
       else return index+1;
    }

}
