package com.maginazt;

/**
 * Created by zhaotao on 16/7/23.
 */
public class Number38 {

    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String result = "1";
        for(int i=1;i<=n-1;i++)
            result = translate(result);
        return result;
    }

    private String translate(String seq) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char currentNumber = ' ';
        int occurs = 0;
        while (index < seq.length()){
            if(currentNumber != seq.charAt(index)){
                if(index != 0){
                    sb.append(occurs).append(currentNumber);
                }
                currentNumber = seq.charAt(index);
                occurs = 1;
            }
            else
                ++occurs;
            ++index;
        }
        sb.append(occurs).append(currentNumber);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number38().countAndSay(50));
    }
}
