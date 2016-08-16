package com.maginazt.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Number68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int startWordIndexOfLine = 0;
        int wordsTotalLengthOfLine = 0;
        int index = 0;
        while(index < words.length){
            String currentWord = words[index];
            if(wordsTotalLengthOfLine == 0){
                wordsTotalLengthOfLine += currentWord.length();
                ++index;
                if(index == words.length)
                    formatThisLine(words, startWordIndexOfLine, index, wordsTotalLengthOfLine, maxWidth, sb, result);
            }
            else if(wordsTotalLengthOfLine + currentWord.length() + 1 <= maxWidth){
                wordsTotalLengthOfLine += currentWord.length() + 1;
                ++index;
                if(index == words.length)
                    formatThisLine(words, startWordIndexOfLine, index, wordsTotalLengthOfLine, maxWidth, sb, result);
            }
            //need to format this line
            else{
                formatThisLine(words, startWordIndexOfLine, index, wordsTotalLengthOfLine, maxWidth, sb, result);
                startWordIndexOfLine = index;
                wordsTotalLengthOfLine = 0;
            }
        }
        return result;
    }

    private void formatThisLine(String[] words, int startWordIndexOfLine, int endWordIndexOfLine, int wordsTotalLengthOfLine, int maxWidth, StringBuilder sb, List<String> result) {
        int wordCount = endWordIndexOfLine - startWordIndexOfLine;
        int spacesLeft = maxWidth - wordsTotalLengthOfLine;
        //one word in this line, left justify
        if(wordCount == 1){
            sb.append(words[startWordIndexOfLine]);
            for(int i=0;i<spacesLeft;i++)
                sb.append(' ');
        }
        else{
            //last line, left justify
            if(endWordIndexOfLine == words.length){
                for(int i=startWordIndexOfLine;i<endWordIndexOfLine;i++)
                    sb.append(words[i]).append(' ');
                sb.deleteCharAt(sb.length()-1);
                for(int i=0;i<spacesLeft;i++)
                    sb.append(' ');
            }
            else{
                while(wordCount > 1){
                    sb.append(words[startWordIndexOfLine]);
                    int spacesAfter = 1 + spacesLeft/(wordCount-1) + (spacesLeft % (wordCount-1) ==0 ? 0 : 1);
                    for(int i=0;i<spacesAfter;i++)
                        sb.append(' ');
                    ++startWordIndexOfLine;
                    --wordCount;
                    spacesLeft -= spacesAfter - 1;
                }
                sb.append(words[startWordIndexOfLine]);
            }
        }
        result.add(sb.toString());
        sb.delete(0, sb.length());
    }

    public static void main(String[] args) {
        print(new Number68().fullJustify(new String[]{"What","must","be","shall","be."}, 12));
    }

    private static void print(List<String> result){
        for(String s : result)
            System.out.println("\""+s+"\"");
    }
}
