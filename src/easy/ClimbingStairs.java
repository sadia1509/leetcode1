package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    Map<Integer, Integer> memorization = new HashMap<>();
    int climbStairsHelper(int n) {
        if (n <= 1) return n;
        else if (memorization.containsKey(n)) return memorization.get(n);
        else {
            int result = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
            memorization.put(n, result);
            return result;
        }
    }
    public int climbStairs(int n) {
        return climbStairsHelper(n + 1);
    }
}
