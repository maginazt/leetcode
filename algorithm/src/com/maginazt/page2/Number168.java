package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number168 {

    private static final String[] cs = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static StringBuilder sb = new StringBuilder();

    public String convertToTitle(int n) {
        sb.delete(0, sb.length());
        int num = n;
        while (num >= cs.length){
            int mod = num % (cs.length-1);
            if(mod == 0){
                sb.append(cs[cs.length-1]);
                num = num/(cs.length-1) -1;
            }
            else{
                sb.append(cs[mod]);
                num /= cs.length-1;
            }
        }
        sb.append(cs[num]);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number168().convertToTitle(53));
    }
}
