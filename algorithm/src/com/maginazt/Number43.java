package com.maginazt;

/**
 * Created by zhaotao on 16/7/24.
 */
public class Number43 {

    public String multiply(String num1, String num2) {
        String result = "0";
        if("".equals(num1) || "0".equals(num1) || "".equals(num2) || "0".equals(num2))
            return result;
        for(int i=num2.length()-1;i>=0;i--)
            result = add(multiply(num1, num2.charAt(i), num2.length()-1-i), result);
        return result;
    }

    private String add(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;
        while(index1 >= 0 && index2 >= 0){
            int currentSum = (num1.charAt(index1)-'0') + (num2.charAt(index2) - '0') + carry;
            if(currentSum > 9){
                carry = 1;
                currentSum -= 10;
            }
            else
                carry = 0;
            sb.append(currentSum);
            --index1;
            --index2;
        }
        while(index1 >= 0){
            int currentSum = (num1.charAt(index1)-'0') + carry;
            if(currentSum > 9){
                carry = 1;
                currentSum -= 10;
            }
            else
                carry = 0;
            sb.append(currentSum);
            --index1;
        }
        while(index2 >= 0){
            int currentSum = (num2.charAt(index2)-'0') + carry;
            if(currentSum > 9){
                carry = 1;
                currentSum -= 10;
            }
            else
                carry = 0;
            sb.append(currentSum);
            --index2;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private String multiply(String num, char digit, int zeros){
        if(digit == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<zeros;i++)
            sb.append(0);
        int carry = 0;
        for(int index=num.length()-1;index>=0;index--){
            int currentMul = (num.charAt(index)-'0') * (digit-'0') + carry;
            if(currentMul > 9){
                carry = currentMul / 10;
                currentMul = currentMul % 10;
            }
            else
                carry = 0;
            sb.append(currentMul);
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number43().multiply("999", "999"));
    }
}
