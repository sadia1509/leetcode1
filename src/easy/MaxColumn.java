package easy;

public class MaxColumn {
    public int[] findColumnWidth(int[][] grid) {
        int [] msxColumnCount = new int[grid[0].length];
        for (int [] row : grid){
            for (int j=0; j< row.length; j++) {
                int digitCount = (row[j] == 0) ? 1 : (int) Math.log10(Math.abs(row[j])) + 1;
                if(row[j]<0) digitCount++;
                msxColumnCount[j] = Math.max(digitCount, msxColumnCount[j]);
            }
        }
        return msxColumnCount;
    }
}
