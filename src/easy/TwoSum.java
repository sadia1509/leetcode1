package easy;

import java.util.*;

public class TwoSum {
    List<Integer> result = new LinkedList<>();

    void whichTwo(int[] nums, int target, int index) {
        if (index < nums.length - 1)
            if (!innerLoop(nums, target, index + 1, index))
                whichTwo(nums, target, ++index);
    }

    boolean innerLoop(int[] nums, int target, int index, int outerLoopIndex) {
        if (index >= nums.length) return false;
        else if (nums[index] + nums[outerLoopIndex] == target) {
            result.add(outerLoopIndex);
            result.add(index);
            return true;
        } else return innerLoop(nums, target, ++index, outerLoopIndex);
    }

    public int[] twoSum(int[] nums, int target) {
        whichTwo(nums, target, 0);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}


/*
Map<Integer, Integer> map = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(i -> i, i -> nums[i]));
        map = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())  //Map.Entry.comparingByValue()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        storeTheIndex(map, target);
 */