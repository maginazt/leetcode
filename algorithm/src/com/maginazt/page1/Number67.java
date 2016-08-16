package com.maginazt.page1;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Number67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int index1 = a.length()-1;
        int index2 = b.length()-1;
        int carry = 0;
        while(index1 >=0 && index2 >=0){
            int num = (a.charAt(index1)-'0') + (b.charAt(index2)-'0') + carry;
            if(num > 1){
                num = num % 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(num);
            --index1;
            --index2;
        }
        while(index1 >= 0){
            int num = (a.charAt(index1)-'0') + carry;
            if(num > 1){
                num = num % 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(num);
            --index1;
        }
        while(index2 >= 0){
            int num = (b.charAt(index2)-'0') + carry;
            if(num > 1){
                num = num % 2;
                carry = 1;
            }
            else
                carry = 0;
            sb.append(num);
            --index2;
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number67().addBinary("111", "111"));
    }
}
