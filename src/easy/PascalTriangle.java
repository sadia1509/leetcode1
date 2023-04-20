package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    List<List<Integer>> pascalTriangleList = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        generateList(numRows, 0);
        return pascalTriangleList;
    }

    public List<Integer> getRow(int rowIndex) {
        for(int i=0; i<rowIndex+1; i++)
            pascalTriangleList.add(i, generateInnerList(i+1, new ArrayList<>(), 0));
        return pascalTriangleList.get(rowIndex);
    }

    void generateList(int num, int index){
        if(index < num){
            pascalTriangleList.add(index, generateInnerList(index+1, new ArrayList<>(), 0));
            generateList(num, ++index);
        }
    }

    List<Integer> generateInnerList(int n, List<Integer> list, int i){
        if(i>=n) return list;
        else {
            if(i==0 || i==(n-1)) list.add(1);
            else list.add(pascalTriangleList.get(n-2).get(i)+pascalTriangleList.get(n-2).get(i-1));
            return generateInnerList(n, list, ++i);
        }
    }
}
