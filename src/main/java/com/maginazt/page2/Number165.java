package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number165 {

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int prevLength = Math.min(versions1.length, versions2.length);
        int result = 0;
        int num = 0;
        while (num < prevLength && (result = cmp(versions1[num], versions2[num])) == 0)
            ++num;
        if(result != 0)
            return result;
        if(versions1.length > prevLength){
            for(int i=prevLength;i<versions1.length;i++){
                if(Integer.parseInt(versions1[i]) != 0)
                    return 1;
            }
        }
        else if(versions2.length > prevLength){
            for(int i=prevLength;i<versions2.length;i++){
                if(Integer.parseInt(versions2[i]) != 0)
                    return -1;
            }
        }
        return 0;
    }

    private int cmp(String v1, String v2) {
        int n1 = Integer.parseInt(v1);
        int n2 = Integer.parseInt(v2);
        return Integer.compare(n1, n2);
    }

    public static void main(String[] args) {
    }
}
