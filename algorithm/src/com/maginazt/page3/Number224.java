package com.maginazt.page3;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/19.
 */
public class Number224 {

    private static final char PLUS = '+';
    private static final char MINUS = '-';

    private static final LinkedList<Character> stack = new LinkedList<>();

    public int calculate(String s) {
        int result = 0;
        stack.clear();
        int numberMinus = 0;
        char prevSymbol = '+';
        int index = 0;
        while (index < s.length()){
            char c = s.charAt(index);
            switch (c){
                case ' ':
                    ++index;
                    continue;
                case '+':
                case '-':
                    prevSymbol = c;
                    ++index;
                    continue;
                case '(':
                    if(prevSymbol == MINUS){
                        ++numberMinus;
                        stack.push(MINUS);
                    }
                    else{
                        stack.push(PLUS);
                    }
                    prevSymbol = '(';
                    ++index;
                    continue;
                case ')':
                    char sign = stack.pop();
                    if(sign == MINUS)
                        --numberMinus;
                    ++index;
                    continue;
                default:
                    int num = c - '0';
                    ++index;
                    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                        num = 10 * num + (s.charAt(index) - '0');
                        ++index;
                    }
                    boolean isAdd;
                    if(prevSymbol == '-')
                        isAdd = (numberMinus+1)%2 == 0;
                    else
                        isAdd = numberMinus%2 == 0;
                    if(isAdd)
                        result += num;
                    else
                        result -= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number224().calculate("(6+(9-(5+7-9)+(7-9+10))-(11+(9-2)-(8-6))+9)"));
    }
}
