package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/27.
 */
public class Number135 {

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        if(ratings.length == 1)
            return 1;
        return -1;
    }

//    public int candy(int[] ratings) {
//        if(ratings == null || ratings.length == 0)
//            return 0;
//        if(ratings.length == 1)
//            return 1;
//        int total = 0;
//        int startIndex = 0;
//        int sum = 1;
//        int prevCandy = 1;
//        int prev = ratings[0];
//        int minCandy = 1;
//        int index = 1;
//        while(index < ratings.length){
//            if(ratings[index] == prev){
//                total += sum + (index-startIndex) * (1 - minCandy);
//                int mostLeft = index - 1;
//                while(index < ratings.length -1 && ratings[index] == ratings[index+1])
//                    ++index;
//                if(index == ratings.length - 1){
//                    total += index - mostLeft;
//                    break;
//                }
//                else{
//                    total += index - mostLeft -1;
//                    startIndex = index;
//                    sum = 1;
//                    prevCandy = 1;
//                    prev = ratings[index];
//                    minCandy = 1;
//                    ++index;
//                }
//            }
//            else{
//                int candy;
//                if(ratings[index] > prev)
//                    candy = prevCandy + 1;
//                else{
//                    candy = Math.min(prevCandy - 1, minCandy);
//                }
//                sum += candy;
//                prevCandy = candy;
//                prev = ratings[index];
//                if(candy < minCandy)
//                    minCandy = candy;
//                ++index;
//            }
//        }
//        if(index == ratings.length)
//            total += sum + (index-startIndex) * (1 - minCandy);
//        return total;
//    }

    public static void main(String[] args) {
        System.out.println(new Number135().candy(new int[]{1,2,2,2,1,2,2,2}));
    }
}
