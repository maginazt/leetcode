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
        int total = 0;
        //U shape start index
        int startIndex = 0;
        //U shape sum
        int sum = 1;
        //candy of previous person
        int prevCandy = 1;
        //rating of pervious person
        int prev = ratings[0];
        //U shape's minimum candy
        int minCandy = 1;
        //seperate U shapes
        boolean canGoDown = true;
        int index = 1;
        while(index < ratings.length){
            //deal with same ratings
            if(ratings[index] == prev){
                total += sum + (index-startIndex) * (1 - minCandy);
                int mostLeft = index - 1;
                while(index < ratings.length -1 && ratings[index] == ratings[index+1])
                    ++index;
                if(index == ratings.length - 1){
                    total += index - mostLeft;
                    break;
                }
                else{
                    total += index - mostLeft -1;
                    startIndex = index;
                    sum = 1;
                    prevCandy = 1;
                    prev = ratings[index];
                    minCandy = 1;
                    ++index;
                }
            }
            else{
                int candy;
                if(ratings[index] > prev){
                    canGoDown = false;
                    candy = prevCandy + 1;
                    sum += candy;
                    prevCandy = candy;
                    prev = ratings[index];
                    if(candy < minCandy)
                        minCandy = candy;
                    ++index;
                }
                else{
                    if(canGoDown){
                        candy = prevCandy - 1;
                        sum += candy;
                        prevCandy = candy;
                        prev = ratings[index];
                        if(candy < minCandy)
                            minCandy = candy;
                        ++index;
                    }
                    else{
                        total += sum + (index-startIndex) * (1 - minCandy) + diff(prevCandy-minCandy+1, ratings, index);
                        canGoDown = true;
                        startIndex = index;
                        sum = 1;
                        prevCandy = 1;
                        prev = ratings[index];
                        minCandy = 1;
                        ++index;
                    }
                }
            }
        }
        if(index == ratings.length)
            total += sum + (index-startIndex) * (1 - minCandy);
        return total;
    }

    private int diff(int candyLeft, int[] ratings, int index) {
        int candyRight = 1;
        int prev = ratings[index-1];
        while(index < ratings.length && ratings[index] < prev){
            ++candyRight;
            prev = ratings[index];
            ++index;
        }
        if(candyRight > candyLeft)
            return candyRight - candyLeft;
        else
            return 0;
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
        System.out.println(new Number135().candy(new int[]{1,3,4,3,2,1}));
    }
}
