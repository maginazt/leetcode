package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/27.
 */
public class Number134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int benefitsBefore = 0;
        int startIndex = -1;
        int benefitsCurrent = 0;
        for(int i=0;i<gas.length;i++){
            int benefit = gas[i] - cost[i];
            if(startIndex == -1){
                if(benefit >= 0){
                    startIndex = i;
                    benefitsCurrent = benefit;
                }
                else{
                    benefitsBefore += benefit;
                }
            }
            else{
                benefitsCurrent += benefit;
                if(benefitsCurrent < 0){
                    startIndex = -1;
                    benefitsBefore += benefitsCurrent;
                }
            }
        }
        if(startIndex == -1)
            return -1;
        else{
            if(benefitsCurrent + benefitsBefore >= 0)
                return startIndex;
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {4,1,1,6,4,3,1,7};
        int[] cost = {9,0,2,3,2,8,2,1};
        System.out.println(new Number134().canCompleteCircuit(gas, cost));
    }
}
