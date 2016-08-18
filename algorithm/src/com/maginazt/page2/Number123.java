package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/18.
 */
public class Number123 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int d = 0;
        int buyDay = 0;
        int sellDay = 0;
        //first find the most profit play
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[d]){
                int diff = prices[i] - prices[d];
                if(diff > profit){
                    profit = diff;
                    buyDay = d;
                    sellDay = i;
                }
            }
            else if(prices[i] < prices[d])
                d = i;
        }
        if(profit == 0)
            return 0;
        profit += Math.max(Math.max(maxProfit(prices, 0, buyDay+1), maxProfit(prices, sellDay, prices.length)), maxDist(prices, buyDay+1, sellDay-1));
        return profit;
    }

    private int maxDist(int[] prices, int start, int end) {
        int maxDist = 0;
        int s = start;
        for(int i=start+1;i<=end;i++){
            if(prices[i] < prices[s]){
                int dist = prices[s] - prices[i];
                if(dist > maxDist)
                    maxDist = dist;
            }
            else if(prices[i] > prices[s])
                s = i;
        }
        return maxDist;
    }

    public int maxProfit(int[] prices, int start, int end) {
        int profit = 0;
        int sellDay = start;
        for(int i=start+1;i<end;i++){
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
        System.out.println(new Number123().maxProfit(new int[]{2,1,4,5,2,9,7}));
    }
}
