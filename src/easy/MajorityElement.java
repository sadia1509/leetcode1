package easy;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = generateMap(new HashMap<>(), nums, 0);
        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
    HashMap<Integer, Integer> generateMap(HashMap<Integer,Integer> map, int[] nums, int i) {
        if (i >= nums.length) return map;
        else {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
            return generateMap(map, nums, ++i);
        }
    }
}
