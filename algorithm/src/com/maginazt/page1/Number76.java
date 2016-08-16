package com.maginazt.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 16/7/30.
 */
public class Number76 {

    private static final Map<Character, Integer> patternMap = new HashMap<>();
    private static final Map<Character, Integer> currentMap = new HashMap<>();
    private static final Map<Character, Integer> clearMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int minWindowStart = 0;
        int minWindowLength = Integer.MAX_VALUE;
        String result = "";
        patternMap.clear();
        currentMap.clear();
        clearMap.clear();
        for(int i=0;i<t.length();i++){
            Character key = t.charAt(i);
            if(patternMap.containsKey(key))
                patternMap.put(key, patternMap.get(key)+1);
            else
                patternMap.put(key, 1);
        }
        clearMap.putAll(patternMap);
        int index = 0;
        while(index < s.length()){
            Character ch = s.charAt(index);
            if(patternMap.containsKey(ch)){
                if(currentMap.containsKey(ch))
                    currentMap.put(ch, currentMap.get(ch)+1);
                else
                    currentMap.put(ch, 1);
                if(!clearMap.isEmpty()){
                    if(clearMap.containsKey(ch) && clearMap.get(ch) > 1)
                        clearMap.put(ch, clearMap.get(ch)-1);
                    else
                        clearMap.remove(ch);
                }
                if(clearMap.isEmpty()){
                    //adjust the window start index
                    while (true){
                        Character lft = s.charAt(minWindowStart);
                        if(!patternMap.containsKey(lft)){
                            ++minWindowStart;
                            continue;
                        }
                        else if(currentMap.get(lft) > patternMap.get(lft)){
                            currentMap.put(lft, currentMap.get(lft)-1);
                            ++minWindowStart;
                            continue;
                        }
                        else
                            break;
                    }
                    int length = index - minWindowStart + 1;
                    if(length < minWindowLength){
                        minWindowLength = length;
                        result = s.substring(minWindowStart, minWindowStart+minWindowLength);
                    }
                }
            }
            ++index;
        }
        if(!clearMap.isEmpty())
            return "";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number76().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
