package easy;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = (heights.length - 1) / 2; i >= 0; i--)
            maxHeapify(heights, names, names.length, i);
        for (int i = heights.length - 1; i > 0; i--) {
            swap(heights, names, 0, i);
            maxHeapify(heights, names, i, 0);
        }
        return names;
    }

    void maxHeapify(int[] heights, String[] names, int length, int index) {
        int smallest = index, left = 2 * index + 1, right = 2 * index + 2;
        if (left < length && heights[left] < heights[smallest])
            smallest = left;
        if (right < length && heights[right] < heights[smallest])
            smallest = right;
        if (smallest != index) {
            swap(heights, names, smallest, index);
            maxHeapify(heights, names, length, smallest);
        }

    }

    void swap(int[] heights, String[] names, int i, int j) {
        int tempHeight = heights[i];
        heights[i] = heights[j];
        heights[j] = tempHeight;

        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;
    }


}
