package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/19.
 */
public class Number227 {

    private int getPriority(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            default:
                return 2;
        }
    }

    public int calculate(String s) {
        int index = 0;
        int num1 = -1;
        boolean num1IsSet = false;
        char op1 = 0;
        int num2 = -1;
        boolean num2IsSet = false;
        char op2 = 0;
        while (index < s.length()){
            char c = s.charAt(index);
            switch (c){
                case ' ':
                    ++index;
                    continue;
                case '+':
                case '-':
                case '*':
                case '/':
                    if(op1 == 0)
                        op1 = c;
                    else
                        op2 = c;
                    ++index;
                    continue;
                default:
                    int num = c - '0';
                    ++index;
                    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                        num = 10 * num + (s.charAt(index) - '0');
                        ++index;
                    }
                    if(!num1IsSet){
                        num1 = num;
                        num1IsSet = true;
                    }
                    else if(!num2IsSet){
                        num2 = num;
                        num2IsSet = true;
                    }
                    else{
                        //right associative
                        if(getPriority(op1) < getPriority(op2)){
                            num2 = op2 == '*' ? num2 * num : num2 / num;
                        }
                        //left associative
                        else{
                            switch (op1){
                                case '+':
                                    num1 = num1 + num2;
                                    break;
                                case '-':
                                    num1 = num1 - num2;
                                    break;
                                case '*':
                                    num1 = num1 * num2;
                                    break;
                                default:
                                    num1 = num1 / num2;
                            }
                            op1 = op2;
                            num2 = num;
                        }
                    }
            }
        }
        if(op1 == 0)
            return num1;
        else{
            switch (op1){
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                default:
                    return num1 / num2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number227().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
