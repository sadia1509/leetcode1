package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        int counter = 1;
        for (int i = 0; i < nums.length - 1; i++, counter++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 1000;
                counter--;
            }
        }
        Arrays.sort(nums);
        for (int n : nums) {
            System.out.print(n + "  ");
        }
        return counter;
    }



    public int removeElement(int[] nums, int val) {
        int counter=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j=i;
                while (j<nums.length-1){
                    nums[j]=nums[++j];
                }
                counter++;
            }
        }
        System.out.println( nums.length - counter + " --- " +Arrays.toString(nums)  );
    return nums.length - counter;
    }



    /*
    public int removeElement(int[] nums, int val) {
        int counter=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums = changeMe(nums, i--);
                counter++;
            }
        }
        for (int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println(counter);
        return counter;
    }

    int [] changeMe(int [] nums, int index){
        List<Integer> arr= IntStream.of(nums) .boxed().collect(Collectors.toList());
        arr.remove(index);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

     */
}
