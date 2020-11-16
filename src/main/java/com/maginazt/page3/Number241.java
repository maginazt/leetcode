package com.maginazt.page3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/30.
 */
public class Number241 {

    private int[] numbers;
    private char[] operators;

    private List<Integer>[][] cache;

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        parse(input);
        switch (numbers.length){
            case 0:
                break;
            case 1:
                result.add(numbers[0]);
                break;
            case 2:
                switch (operators[0]){
                    case '+':
                        result.add(numbers[0]+numbers[1]);
                        break;
                    case '-':
                        result.add(numbers[0]-numbers[1]);
                        break;
                    case '*':
                        result.add(numbers[0]*numbers[1]);
                        break;
                }
                break;
            default:
                cache = new List[numbers.length][numbers.length];
                result = find(0, numbers.length-1);
        }
        return result;
    }

    private List<Integer> find(int start, int end) {
        if(cache[start][end] != null)
            return cache[start][end];
        List<Integer> result = new ArrayList<>();

        cache[start][end] = result;
        return result;
    }

    private void parse(String input) {
        if(input != null && !"".equals(input)){
            String[] nums = input.split("[-+*]");
            numbers = new int[nums.length];
            operators = new char[nums.length-1];
            int index = 0;
            for(int i=0;i<nums.length;i++){
                numbers[i] = Integer.parseInt(nums[i]);
                index += nums[i].length();
                if(index < input.length()){
                    operators[i] = input.charAt(index);
                    index += 1;
                }
            }
        }
        else
            numbers = new int[0];
    }

    public static void main(String[] args) {
        System.out.println(new Number241().diffWaysToCompute("2-1+2"));
    }
}
