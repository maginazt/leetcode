package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/18.
 */
public class Number121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int sellDay = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[sellDay]){
                int diff = prices[i] - prices[sellDay];
                if(diff > profit)
                    profit = diff;
            }
            else if(prices[i] < prices[sellDay])
                sellDay = i;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Number121().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
