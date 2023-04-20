package easy;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class StockSellBuy {

//2,1,2,1,0,1,2
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
             else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
/*
    int minIndex = 0, maxIndex = 0, limit = 0;

    public int maxProfit(int[] prices) {
        limit = prices.length;
        while (maxIndex == minIndex && limit>0) {
            maxProfitHelper(prices, limit);
            limit = minIndex;
        }
        return maxIndex == minIndex ? 0 : prices[maxIndex] - prices[minIndex];
    }

    void maxProfitHelper(int[] prices, int limit) {
        minIndex = findMin(prices, 0, limit - 1, limit);
        maxIndex = findMax(prices, minIndex, minIndex);
        System.out.println(minIndex + " "+ maxIndex);
    }

    int findMax(int[] prices, int i, int max) {
        if (i >= prices.length) return max;
        else {
            if (prices[i] >= prices[max]) max = i;
            return findMax(prices, ++i, max);
        }
    }

    int findMin(int[] prices, int i, int min, int limit) {
        if (i >= limit) return min;
        else {
            if (prices[i] <= prices[min] && prices[i]!=0 ) min = i;
            return findMin(prices, ++i, min, limit);
        }
    }




    public int maxProfit(int[] prices) {
        IntSummaryStatistics stat = Arrays.stream(prices).summaryStatistics();
        return -1;
    }
    int maxProfitHelper(int[] prices, int i, IntSummaryStatistics stat){
        if (i >= prices.length) return -1;
        else {
            if(prices[i]==stat.getMin()){
                int j = i+1, maxProfit = 0;
                if (j==prices.length) return maxProfit;
                maxProfit=prices[i];
                while( j<prices.length) {
                    maxProfit=Math.max(maxProfit, prices[j++]);
                }
                return maxProfit-stat.getMin();
            }
        }
        return -1;
    }
    */

}

//7,1,5,3,6,4