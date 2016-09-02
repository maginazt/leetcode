package com.maginazt.page2;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/8/31.
 */
public class Number150 {

    private static final LinkedList<String> stack = new LinkedList<>();

    public int evalRPN(String[] tokens) {
        stack.clear();
        for(String token : tokens){
            if(isNumber(token)){
                stack.push(token);
            }
            else{
                Integer num2 = Integer.parseInt(stack.pop());
                Integer num1 = Integer.parseInt(stack.pop());
                stack.push(operate(num1, token, num2));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String operate(Integer num1, String token, Integer num2) {
        switch (token){
            case "+":
                return String.valueOf(num1+num2);
            case "-":
                return String.valueOf(num1-num2);
            case "*":
                return String.valueOf(num1*num2);
            default:
                return String.valueOf(num1/num2);
        }
    }

    private boolean isNumber(String token){
        switch (token){
            case "+":
            case "-":
            case "*":
            case "/":
                return false;
            default:
                return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number150().evalRPN(new String[]{"18"}));
    }
}
