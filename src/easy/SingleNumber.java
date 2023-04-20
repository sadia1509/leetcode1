package easy;

import java.util.*;
import java.util.stream.Collectors;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = generateHashSet(new HashSet<>(), nums, 0);
        return Integer.parseInt(hashSet.iterator().next().toString());
    }

    HashSet<Integer> generateHashSet(HashSet<Integer> hashSet, int[] nums, int i) {
        if (i >= nums.length) return hashSet;
        else {
            if (hashSet.contains(nums[i])) hashSet.remove(nums[i]);
            else hashSet.add(nums[i]);
            return generateHashSet(hashSet, nums, ++i);
        }
    }
}
