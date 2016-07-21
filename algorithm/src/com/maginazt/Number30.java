package com.maginazt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Number30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s!=null && !"".equals(s) && words != null && words.length > 0){
            List<List<Integer>> ranges = new LinkedList<>();
            for(String word : words){
                if(s.indexOf(word) < 0)
                    return result;
                int index = 0;
                while((index = s.indexOf(word, index)) != -1){
                    if(ranges.size() == 0){
                        List<Integer> found = new ArrayList<>();
                        found.add(index);
                        ranges.add(found);
                    }
                    else{
                        List<List<Integer>> newRanges = new LinkedList<>();
                        for(List<Integer> found : ranges){
                            boolean isValid = true;
                            for(Integer oldNum : found){
//                                if(!isValid(oldNum, index, word.length())){
//                                    isValid = false;
//                                    break;
//                                }
                            }
                            if(isValid){
                                List<Integer> newFound = new ArrayList<>(found);
                            }
                        }
                        if(newRanges.size() == 0)
                            return result;
                    }
                    index += 1;
                }
            }
        }
        return result;
    }
}
