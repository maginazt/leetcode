package com.maginazt.page2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by zhaotao on 2016/8/22.
 */
public class Number126 {

    private static ArrayList<List<String>> levelNodes = new ArrayList<>();
    private static ArrayList<List<String>> parrentIndexes = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        levelNodes.clear();
        parrentIndexes.clear();
        List<String> first = new ArrayList<>();
        first.add(beginWord);
        levelNodes.add(first);
        parrentIndexes.add(null);
        wordList.add(endWord);
        boolean lastWordMeeted = false;
        StringBuilder lastWordParents = new StringBuilder();
        int currentLevel = 0;
        Map<String, Integer> map = new HashMap<>();
        while (currentLevel < levelNodes.size() && !lastWordMeeted){
            List<String> currentNodes = levelNodes.get(currentLevel);
            int size = currentNodes.size();
            map.clear();
            for(int i=0;i<size;i++){
                wordList.remove(currentNodes.get(i));
                char[] curWord = currentNodes.get(i).toCharArray();
                //wordList is so big that even enumerate all possible word is faster enough
                for(int c=0;c<curWord.length;c++){
                    for(char x='a';x<='z';x++){
                        char old = curWord[c];
                        curWord[c] = x;
                        String word = new String(curWord);
                        if(wordList.contains(word)){
                            if(word.equals(endWord)){
                                lastWordMeeted = true;
                                lastWordParents.append(i).append("|");
                            }
                            else if(!lastWordMeeted){
                                List<String> nodes;
                                List<String> parrents;
                                if(currentLevel < levelNodes.size()-1){
                                    nodes = levelNodes.get(currentLevel+1);
                                    parrents = parrentIndexes.get(currentLevel+1);
                                }
                                else{
                                    nodes = new ArrayList<>();
                                    levelNodes.add(nodes);
                                    parrents = new ArrayList<>();
                                    parrentIndexes.add(parrents);
                                }
                                if(!map.containsKey(word)){
                                    nodes.add(word);
                                    parrents.add(String.valueOf(i));
                                    map.put(word, nodes.size()-1);
                                }
                                else{
                                    Integer index = map.get(word);
                                    parrents.set(index, parrents.get(index)+"|"+i);
                                }
                            }
                        }
                        curWord[c] = old;
                    }
                }
            }
            ++currentLevel;
        }
        if(lastWordParents.length() > 0)
            return findThePath(currentLevel-1, endWord, lastWordParents.deleteCharAt(lastWordParents.length()-1).toString());
        else
            return new ArrayList<>();
    }

    private List<List<String>> findThePath(int currentLevel, String endWord, String lastWordParents) {
        LinkedList<List<String>> paths = new LinkedList<>();
        LinkedList<Integer> currentIndexes = new LinkedList<>();
        dealWithLastLayer(lastWordParents, endWord, currentIndexes, currentLevel, paths);
        while(currentLevel > 0){
            int size = paths.size();
            for(int k=0;k<size;k++){
                List<String> path = paths.removeFirst();
                String parents = parrentIndexes.get(currentLevel).get(currentIndexes.removeFirst());
                String[] parentArr = parents.split("\\|");
                Integer i0 = Integer.parseInt(parentArr[0]);
                path.add(levelNodes.get(currentLevel-1).get(i0));
                paths.add(path);
                currentIndexes.addLast(i0);
                for(int i=1;i<parentArr.length;i++){
                    List<String> newPath = new ArrayList<>(path);
                    newPath.remove(newPath.size()-1);
                    Integer ii = Integer.parseInt(parentArr[i]);
                    newPath.add(levelNodes.get(currentLevel-1).get(ii));
                    paths.addLast(newPath);
                    currentIndexes.addLast(ii);
                }
            }
            --currentLevel;
        }
        for(List<String> path : paths)
            Collections.reverse(path);
        return paths;
    }

    private void dealWithLastLayer(String lastWordParents, String endWord, LinkedList<Integer> currentIndexes, int currentLevel, LinkedList<List<String>> paths) {
        List<String> initialPath = new ArrayList<>();
        initialPath.add(endWord);
        String[] parentArr = lastWordParents.split("\\|");
        Integer i0 = Integer.parseInt(parentArr[0]);
        initialPath.add(levelNodes.get(currentLevel).get(i0));
        paths.addLast(initialPath);
        currentIndexes.addLast(i0);
        for(int i=1;i<parentArr.length;i++){
            List<String> path = new ArrayList<>(initialPath);
            path.remove(path.size()-1);
            Integer ii = Integer.parseInt(parentArr[i]);
            path.add(levelNodes.get(currentLevel).get(ii));
            paths.addLast(path);
            currentIndexes.addLast(ii);
        }
    }

    public static void main(String[] args) throws Exception{
        Set<String> wordList = new HashSet<>();
//        wordList.add("hot");
////        wordList.add("dot");
//        wordList.add("dog");
////        wordList.add("lot");
////        wordList.add("log");
//        System.out.println(new Number126().findLadders("hot", "dog", wordList));
//        wordList.add("ted");
//        wordList.add("tex");
//        wordList.add("red");
//        wordList.add("tax");
//        wordList.add("tad");
//        wordList.add("den");
//        wordList.add("rex");
//        wordList.add("pee");
//        System.out.println(new Number126().findLadders("red", "tax", wordList));
//        System.out.println(levelNodes);
//        System.out.println(parrentIndexes);
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\test.txt"));
        String words = br.readLine();
        for(String word : words.split(",")){
            wordList.add(word.replace("\"", ""));
        }
//        Number127 number127 = new Number127();
//        long start = System.currentTimeMillis();
//        int length = number127.ladderLength("nanny", "aloud", wordList);
//        System.out.println("time: "+(System.currentTimeMillis()-start));
//        System.out.println(length);
        Number126 number126 = new Number126();
        long start = System.currentTimeMillis();
        List<List<String>> length = number126.findLadders("nanny", "aloud", wordList);
        System.out.println("time: "+(System.currentTimeMillis()-start));
        System.out.println(length);
    }
}
