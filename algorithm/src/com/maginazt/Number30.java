package com.maginazt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Number30 {

//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> result = new ArrayList<>();
//        if(s!=null && !"".equals(s) && words != null && words.length > 0){
//            int wordLength = words[0].length();
//            int wordNumber = words.length;
//            //same words can be merged, and will not affect the result
//            Set<String> allSame = new HashSet<>();
//            for(String word : words)
//                allSame.add(word);
//            if(allSame.size() == 1){
//                StringBuilder sb = new StringBuilder();
//                for(int i=0;i<words.length;i++)
//                    sb.append(words[0]);
//                String word = sb.toString();
//                int index = 0;
//                while((index = s.indexOf(word, index)) != -1){
//                    result.add(index);
//                    index += 1;
//                }
//                return result;
//            }
//            List<List<Integer>>[] ranges = new List[2];
//            ranges[0] = new ArrayList<>();
//            ranges[1] = new ArrayList<>();
//            int flag = 0;
//            for(String word : words){
//                if(s.indexOf(word) < 0)
//                    return result;
//                List<List<Integer>> sourceRange = ranges[flag];
//                int index = 0;
//                if(sourceRange.isEmpty()){
//                    while((index = s.indexOf(word, index)) != -1){
//                        List<Integer> found = new ArrayList<>();
//                        found.add(index);
//                        sourceRange.add(found);
//                        ++index;
//                    }
//                }
//                else{
//                    flag = (flag+1)%2;
//                    List<List<Integer>> targetRange = ranges[flag];
//                    targetRange.clear();
//                    while((index = s.indexOf(word, index)) != -1){
//                        for(List<Integer> found : sourceRange){
//                            boolean isValid = true;
//                            for(Integer oldNum : found){
//                                if(!isValid(oldNum, index, wordLength, wordNumber)){
//                                    isValid = false;
//                                    break;
//                                }
//                            }
//                            if(isValid){
//                                List<Integer> newFound = new ArrayList<>(found);
//                                newFound.add(index);
//                                targetRange.add(newFound);
//                            }
//                        }
//                        ++index;
//                    }
//                    if(targetRange.isEmpty())
//                        return result;
//                }
//            }
//            for(List<Integer> found : ranges[flag]){
//                Integer min = Collections.min(found);
//                if(!result.contains(min))
//                    result.add(min);
//            }
//        }
//        return result;
//    }
//
//    private List<String> mergeSameWords(String[] words) {
//        Map<String, Integer> map = new HashMap<>();
//        for(String word : words){
//            if(map.containsKey(word))
//                map.put(word, map.get(word)+1);
//            else
//                map.put(word, 1);
//        }
//        List<String> list = new ArrayList<>();
//        for(String word : map.keySet()){
//            if(map.get(word) > 1){
//                StringBuilder sb = new StringBuilder();
//                for(int i=0;i<map.get(word);i++)
//                    sb.append(word);
//                list.add(sb.toString());
//            }
//            else
//                list.add(word);
//        }
//        return list;
//    }
//
//    private boolean isValid(Integer sourceIndex, int targetIndex, int wordLength, int wordNumber) {
//        int distance = Math.abs((targetIndex - sourceIndex) / wordLength);
//        return (targetIndex - sourceIndex) % wordLength == 0 && distance > 0 && distance < wordNumber;
//    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length())
            return res;
        int targetStrLen = s.length(), wordNumber = words.length, wordLength = words[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < wordLength; i++) {
            int count = 0;  // remark: reset count
            for (int l = i, r = i; r + wordLength <= targetStrLen; r += wordLength) {
                str = s.substring(r, r + wordLength);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) curMap.put(str, curMap.get(str) + 1);
                    else curMap.put(str, 1);

                    if (curMap.get(str) <= map.get(str)) count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = s.substring(l, l + wordLength);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += wordLength;
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                    }
                    if (count == wordNumber) {
                        res.add(l);
                        tmp = s.substring(l, l + wordLength);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += wordLength;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    l = r + wordLength;
                }
            }
            curMap.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Number30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
//        System.out.println(new Number30().findSubstring("aaaaa", new String[]{"a", "a"}));
    }
}
