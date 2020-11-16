package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/25.
 */
public class Number233 {

    public int countDigitOne(int n) {
        if(n <= 0)
            return 0;
        int result = 0;
        int num = n;
        int multiply = 1;
        while (num > 0){
            //当前位
            int digit = num % 10;
            //当前位之前的字符组成的数字
            int high = (num - digit)/10;
            //当前位之后的字符组成的数字
            int low = n - num * multiply;
            switch (digit){
//              若当前位为0，则当前位置的1出现的次数只与高位数字相关
//              每次高位的变化都会在当前位产生multiply个1
                case 0:
                    result += high * multiply;
                    break;
//              若当前位为1，则还与低位数字相关，具体为低位数字的大小加1
                case 1:
                    result += high * multiply + low + 1;
                    break;
//              若当前位大于1，则只与高位数字相关，比第一种情况还多出multiply个1
                default:
                    result += (high + 1) * multiply;
            }
            num /= 10;
            multiply *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number233().countDigitOne(10024));
    }
}
