package com.maginazt.page2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhaotao on 2016/9/5.
 */
public class Number179 {

    private static final Comparator<String> COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()){
                for(int i=0;i<o1.length();i++){
                    if(o1.charAt(i) < o2.charAt(i))
                        return 1;
                    else if(o1.charAt(i) > o2.charAt(i))
                        return -1;
                }
                return 0;
            }
            else{
                int len = Math.min(o1.length(), o2.length());
                for(int i=0;i<len;i++){
                    if(o1.charAt(i) < o2.charAt(i))
                        return 1;
                    else if(o1.charAt(i) > o2.charAt(i))
                        return -1;
                }
                if(o1.length() < o2.length()){
                    //o1 is shorter than o2
                    //e.g. 3, 30, so the suffix is 330, 303
                    //cut off the common prefix, then have 30, 03
                    for(int i=len;i<o2.length();i++){
                        if(o2.charAt(i) < o2.charAt(i-len))
                            return -1;
                        else if(o2.charAt(i) > o2.charAt(i-len))
                            return 1;
                    }
                    for(int i=0;i<o1.length();i++){
                        if(o1.charAt(i) < o2.charAt(i+o2.length()-len))
                            return -1;
                        else if(o1.charAt(i) > o2.charAt(i+o2.length()-len))
                            return 1;
                    }
                    return 0;
                }
                else{
                    for(int i=len;i<o1.length();i++){
                        if(o1.charAt(i) < o1.charAt(i-len))
                            return 1;
                        else if(o1.charAt(i) > o1.charAt(i-len))
                            return -1;
                    }
                    for(int i=0;i<o2.length();i++){
                        if(o2.charAt(i) < o1.charAt(i+o1.length()-len))
                            return 1;
                        else if(o2.charAt(i) > o1.charAt(i+o1.length()-len))
                            return -1;
                    }
                    return 0;
                }
            }
        }
    };

    private static final StringBuilder sb = new StringBuilder();

    public String largestNumber(int[] nums) {
        sb.delete(0, sb.length());
        if(nums !=null && nums.length > 0){
            String[] numbers = new String[nums.length];
            boolean allzero = true;
            for(int i=0;i<nums.length;i++){
                numbers[i] = Integer.toString(nums[i]);
                if(nums[i] != 0)
                    allzero = false;
            }
            if(allzero)
                return "0";
            Arrays.sort(numbers, COMPARATOR);
            for(int i=0;i<numbers.length;i++)
                sb.append(numbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number179().largestNumber(new int[]{30,3}));
    }
}
