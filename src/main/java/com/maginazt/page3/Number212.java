package com.maginazt.page3;

import com.maginazt.structure.TrieNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by zhaotao on 2016/9/8.
 */
public class Number212 {

    private static Set<Integer>[] list;

    private static Set<Integer> footprint = new HashSet<>();

    private static int rows;
    private static int cols;

    public List<String> findWords(char[][] board, String[] words) {
        long start = System.currentTimeMillis();
        compile(board);
        Set<String> result = new HashSet<>();
        TrieNode root = new TrieNode();
        for(String word : words){
            insert(root, word);
        }
        footprint.clear();
        findWords(result, root, new StringBuilder(), null);
        System.out.println(System.currentTimeMillis()-start);
        return new ArrayList<>(result);
    }

    private void findWords(Set<String> result, TrieNode root, StringBuilder builder, Integer preStep) {
        for(int i=0;i<root.nexts.length;i++){
            TrieNode next = root.nexts[i];
            //has link
            if(next != null){
                Set<Integer> nexts = list[i];
                //no paths, return immediately
                if(nexts == null)
                    continue;
                if(preStep == null){
                    for(Integer n : nexts){
                        //has path
                        builder.append((char)(i+'a'));
                        if(next.isWord)
                            result.add(builder.toString());
                        footprint.add(n);
                        findWords(result, next, builder, n);
                        footprint.remove(n);
                        builder.deleteCharAt(builder.length()-1);
                    }
                }
                else{
                    //up
                    int upPos = preStep - cols;
                    if(upPos > 0 && !footprint.contains(upPos) && nexts.contains(upPos)){
                        builder.append((char)(i+'a'));
                        if(next.isWord)
                            result.add(builder.toString());
                        footprint.add(upPos);
                        findWords(result, next, builder, upPos);
                        footprint.remove(upPos);
                        builder.deleteCharAt(builder.length()-1);
                    }
                    //down
                    int downPos = preStep + cols;
                    if(downPos <= rows * cols && !footprint.contains(downPos) && nexts.contains(downPos)){
                        builder.append((char)(i+'a'));
                        if(next.isWord)
                            result.add(builder.toString());
                        footprint.add(downPos);
                        findWords(result, next, builder, downPos);
                        footprint.remove(downPos);
                        builder.deleteCharAt(builder.length()-1);
                    }
                    //left
                    int leftPos = preStep - 1;
                    if(leftPos % cols != 0 && !footprint.contains(leftPos) && nexts.contains(leftPos)){
                        builder.append((char)(i+'a'));
                        if(next.isWord)
                            result.add(builder.toString());
                        footprint.add(leftPos);
                        findWords(result, next, builder, leftPos);
                        footprint.remove(leftPos);
                        builder.deleteCharAt(builder.length()-1);
                    }
                    //right
                    int rightPos = preStep + 1;
                    if(preStep % cols != 0 && !footprint.contains(rightPos) && nexts.contains(rightPos)){
                        builder.append((char)(i+'a'));
                        if(next.isWord)
                            result.add(builder.toString());
                        footprint.add(rightPos);
                        findWords(result, next, builder, rightPos);
                        footprint.remove(rightPos);
                        builder.deleteCharAt(builder.length()-1);
                    }
                }

            }
        }
    }

    public void insert(TrieNode root, String word) {
        if(word != null){
            TrieNode current = root;
            for(int i=0;i<word.length();i++){
                int ch = word.charAt(i) - 'a';
                if(current.nexts[ch] != null){
                    current = current.nexts[ch];
                    if(i == word.length()-1)
                        current.isWord = true;
                }
                else{
                    TrieNode next = new TrieNode();
                    if(i == word.length()-1)
                        next.isWord = true;
                    current.nexts[ch] = next;
                    current = next;
                }
            }
        }
    }

//    private boolean isIn(String word) {
//        footprint.clear();
//        Set<Integer> nexts = list[word.charAt(0)-'a'];
//        if(nexts == null)
//            return false;
//        for(Integer next : nexts){
//            footprint.add(next);
//            if(isIn(word, 1, next))
//                return true;
//            footprint.remove(next);
//        }
//        return false;
//    }
//
//    private boolean isIn(String word, int index, int preStep) {
//        if(index == word.length())
//            return true;
//        int ch = word.charAt(index) - 'a';
//        Set<Integer> poss = list[ch];
//        if(poss == null)
//            return false;
//        //up
//        int upPos = preStep - cols;
//        if(upPos > 0 && !footprint.contains(upPos) && poss.contains(upPos)){
//            footprint.add(upPos);
//            if(isIn(word, index+1, upPos))
//                return true;
//            footprint.remove(upPos);
//        }
//        //down
//        int downPos = preStep + cols;
//        if(downPos <= rows * cols && !footprint.contains(downPos) && poss.contains(downPos)){
//            footprint.add(downPos);
//            if(isIn(word, index+1, downPos))
//                return true;
//            footprint.remove(downPos);
//        }
//        //left
//        int leftPos = preStep - 1;
//        if(leftPos % cols != 0 && !footprint.contains(leftPos) && poss.contains(leftPos)){
//            footprint.add(leftPos);
//            if(isIn(word, index+1, leftPos))
//                return true;
//            footprint.remove(leftPos);
//        }
//        //right
//        int rightPos = preStep + 1;
//        if(preStep % cols != 0 && !footprint.contains(rightPos) && poss.contains(rightPos)){
//            footprint.add(rightPos);
//            if(isIn(word, index+1, rightPos))
//                return true;
//            footprint.remove(rightPos);
//        }
//        return false;
//    }

    private void compile(char[][] board) {
        list = new Set[26];
        rows = board.length;
        cols = board[0].length;
        int foot = 1;
        for(int row=0;row<rows;row++)
            for(int col=0;col<cols;col++){
                int ch = board[row][col] - 'a';
                if(list[ch] == null)
                    list[ch] = new HashSet<>();
                list[ch].add(foot++);
            }
    }

    public static void main(String[] args) throws Exception{
//        char[][] board = new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'b','c','d','e'},{'f','g','h','i'},{'j','k','l','m'},{'n','o','p','q'},{'r','s','t','u'},{'v','w','x','y'},{'z','z','z','z'}};
//        char[][] board = {{'a','b'},{'c','d'}};
        char[][] board = {{'s','e','e','n','e','w'},{'t','m','r','i','v','a'},{'o','b','s','i','b','d'},{'w','m','y','s','e','n'},{'l','t','s','n','s','a'},{'i','e','z','l','g','n'}};
//        System.out.println(new Number212().findWords(board, new String[]{"aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaba","aaaaaaaaaaaaaabb","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabd","aaaaaaaaaaaaaabe","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaabg","aaaaaaaaaaaaaabh","aaaaaaaaaaaaaabi","aaaaaaaaaaaaaabj","aaaaaaaaaaaaaabk","aaaaaaaaaaaaaabl","aaaaaaaaaaaaaabm","aaaaaaaaaaaaaabn","aaaaaaaaaaaaaabo","aaaaaaaaaaaaaabp","aaaaaaaaaaaaaabq","aaaaaaaaaaaaaabr","aaaaaaaaaaaaaabs","aaaaaaaaaaaaaabt","aaaaaaaaaaaaaabu","aaaaaaaaaaaaaabv","aaaaaaaaaaaaaabw","aaaaaaaaaaaaaabx","aaaaaaaaaaaaaaby","aaaaaaaaaaaaaabz","aaaaaaaaaaaaaaca","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacc","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaace","aaaaaaaaaaaaaacf","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaach","aaaaaaaaaaaaaaci","aaaaaaaaaaaaaacj","aaaaaaaaaaaaaack","aaaaaaaaaaaaaacl","aaaaaaaaaaaaaacm","aaaaaaaaaaaaaacn","aaaaaaaaaaaaaaco","aaaaaaaaaaaaaacp","aaaaaaaaaaaaaacq","aaaaaaaaaaaaaacr","aaaaaaaaaaaaaacs","aaaaaaaaaaaaaact","aaaaaaaaaaaaaacu","aaaaaaaaaaaaaacv","aaaaaaaaaaaaaacw","aaaaaaaaaaaaaacx","aaaaaaaaaaaaaacy","aaaaaaaaaaaaaacz","aaaaaaaaaaaaaada","aaaaaaaaaaaaaadb","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaadd","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadf","aaaaaaaaaaaaaadg","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaadi","aaaaaaaaaaaaaadj","aaaaaaaaaaaaaadk","aaaaaaaaaaaaaadl","aaaaaaaaaaaaaadm","aaaaaaaaaaaaaadn","aaaaaaaaaaaaaado","aaaaaaaaaaaaaadp","aaaaaaaaaaaaaadq","aaaaaaaaaaaaaadr","aaaaaaaaaaaaaads","aaaaaaaaaaaaaadt","aaaaaaaaaaaaaadu","aaaaaaaaaaaaaadv","aaaaaaaaaaaaaadw","aaaaaaaaaaaaaadx","aaaaaaaaaaaaaady","aaaaaaaaaaaaaadz","aaaaaaaaaaaaaaea","aaaaaaaaaaaaaaeb","aaaaaaaaaaaaaaec","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaee","aaaaaaaaaaaaaaef","aaaaaaaaaaaaaaeg","aaaaaaaaaaaaaaeh","aaaaaaaaaaaaaaei","aaaaaaaaaaaaaaej","aaaaaaaaaaaaaaek","aaaaaaaaaaaaaael","aaaaaaaaaaaaaaem","aaaaaaaaaaaaaaen","aaaaaaaaaaaaaaeo","aaaaaaaaaaaaaaep","aaaaaaaaaaaaaaeq","aaaaaaaaaaaaaaer","aaaaaaaaaaaaaaes","aaaaaaaaaaaaaaet","aaaaaaaaaaaaaaeu","aaaaaaaaaaaaaaev","aaaaaaaaaaaaaaew","aaaaaaaaaaaaaaex","aaaaaaaaaaaaaaey","aaaaaaaaaaaaaaez","aaaaaaaaaaaaaafa","aaaaaaaaaaaaaafb","aaaaaaaaaaaaaafc","aaaaaaaaaaaaaafd","aaaaaaaaaaaaaafe","aaaaaaaaaaaaaaff","aaaaaaaaaaaaaafg","aaaaaaaaaaaaaafh","aaaaaaaaaaaaaafi","aaaaaaaaaaaaaafj","aaaaaaaaaaaaaafk","aaaaaaaaaaaaaafl","aaaaaaaaaaaaaafm","aaaaaaaaaaaaaafn","aaaaaaaaaaaaaafo","aaaaaaaaaaaaaafp","aaaaaaaaaaaaaafq","aaaaaaaaaaaaaafr","aaaaaaaaaaaaaafs","aaaaaaaaaaaaaaft","aaaaaaaaaaaaaafu","aaaaaaaaaaaaaafv","aaaaaaaaaaaaaafw","aaaaaaaaaaaaaafx","aaaaaaaaaaaaaafy","aaaaaaaaaaaaaafz","aaaaaaaaaaaaaaga","aaaaaaaaaaaaaagb","aaaaaaaaaaaaaagc","aaaaaaaaaaaaaagd","aaaaaaaaaaaaaage","aaaaaaaaaaaaaagf","aaaaaaaaaaaaaagg","aaaaaaaaaaaaaagh","aaaaaaaaaaaaaagi","aaaaaaaaaaaaaagj","aaaaaaaaaaaaaagk","aaaaaaaaaaaaaagl","aaaaaaaaaaaaaagm","aaaaaaaaaaaaaagn","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq","aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu","aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy","aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc","aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg","aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaahj","aaaaaaaaaaaaaahk","aaaaaaaaaaaaaahl","aaaaaaaaaaaaaahm","aaaaaaaaaaaaaahn","aaaaaaaaaaaaaaho","aaaaaaaaaaaaaahp","aaaaaaaaaaaaaahq","aaaaaaaaaaaaaahr","aaaaaaaaaaaaaahs","aaaaaaaaaaaaaaht","aaaaaaaaaaaaaahu","aaaaaaaaaaaaaahv","aaaaaaaaaaaaaahw","aaaaaaaaaaaaaahx","aaaaaaaaaaaaaahy","aaaaaaaaaaaaaahz","aaaaaaaaaaaaaaia","aaaaaaaaaaaaaaib","aaaaaaaaaaaaaaic","aaaaaaaaaaaaaaid","aaaaaaaaaaaaaaie","aaaaaaaaaaaaaaif","aaaaaaaaaaaaaaig","aaaaaaaaaaaaaaih","aaaaaaaaaaaaaaii","aaaaaaaaaaaaaaij","aaaaaaaaaaaaaaik","aaaaaaaaaaaaaail","aaaaaaaaaaaaaaim","aaaaaaaaaaaaaain","aaaaaaaaaaaaaaio","aaaaaaaaaaaaaaip","aaaaaaaaaaaaaaiq","aaaaaaaaaaaaaair","aaaaaaaaaaaaaais","aaaaaaaaaaaaaait","aaaaaaaaaaaaaaiu","aaaaaaaaaaaaaaiv","aaaaaaaaaaaaaaiw","aaaaaaaaaaaaaaix","aaaaaaaaaaaaaaiy","aaaaaaaaaaaaaaiz","aaaaaaaaaaaaaaja","aaaaaaaaaaaaaajb","aaaaaaaaaaaaaajc","aaaaaaaaaaaaaajd","aaaaaaaaaaaaaaje","aaaaaaaaaaaaaajf","aaaaaaaaaaaaaajg","aaaaaaaaaaaaaajh","aaaaaaaaaaaaaaji","aaaaaaaaaaaaaajj","aaaaaaaaaaaaaajk","aaaaaaaaaaaaaajl","aaaaaaaaaaaaaajm","aaaaaaaaaaaaaajn","aaaaaaaaaaaaaajo","aaaaaaaaaaaaaajp","aaaaaaaaaaaaaajq","aaaaaaaaaaaaaajr","aaaaaaaaaaaaaajs","aaaaaaaaaaaaaajt","aaaaaaaaaaaaaaju","aaaaaaaaaaaaaajv","aaaaaaaaaaaaaajw","aaaaaaaaaaaaaajx","aaaaaaaaaaaaaajy","aaaaaaaaaaaaaajz","aaaaaaaaaaaaaaka","aaaaaaaaaaaaaakb","aaaaaaaaaaaaaakc","aaaaaaaaaaaaaakd","aaaaaaaaaaaaaake","aaaaaaaaaaaaaakf","aaaaaaaaaaaaaakg","aaaaaaaaaaaaaakh","aaaaaaaaaaaaaaki","aaaaaaaaaaaaaakj","aaaaaaaaaaaaaakk","aaaaaaaaaaaaaakl","aaaaaaaaaaaaaakm","aaaaaaaaaaaaaakn","aaaaaaaaaaaaaako","aaaaaaaaaaaaaakp","aaaaaaaaaaaaaakq","aaaaaaaaaaaaaakr","aaaaaaaaaaaaaaks","aaaaaaaaaaaaaakt","aaaaaaaaaaaaaaku","aaaaaaaaaaaaaakv","aaaaaaaaaaaaaakw","aaaaaaaaaaaaaakx","aaaaaaaaaaaaaaky","aaaaaaaaaaaaaakz","aaaaaaaaaaaaaala","aaaaaaaaaaaaaalb","aaaaaaaaaaaaaalc","aaaaaaaaaaaaaald","aaaaaaaaaaaaaale","aaaaaaaaaaaaaalf","aaaaaaaaaaaaaalg","aaaaaaaaaaaaaalh","aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk","aaaaaaaaaaaaaall","aaaaaaaaaaaaaalm","aaaaaaaaaaaaaaln","aaaaaaaaaaaaaalo","aaaaaaaaaaaaaalp","aaaaaaaaaaaaaalq","aaaaaaaaaaaaaalr","aaaaaaaaaaaaaals","aaaaaaaaaaaaaalt","aaaaaaaaaaaaaalu","aaaaaaaaaaaaaalv","aaaaaaaaaaaaaalw","aaaaaaaaaaaaaalx","aaaaaaaaaaaaaaly","aaaaaaaaaaaaaalz","aaaaaaaaaaaaaama","aaaaaaaaaaaaaamb","aaaaaaaaaaaaaamc","aaaaaaaaaaaaaamd","aaaaaaaaaaaaaame","aaaaaaaaaaaaaamf","aaaaaaaaaaaaaamg","aaaaaaaaaaaaaamh","aaaaaaaaaaaaaami","aaaaaaaaaaaaaamj","aaaaaaaaaaaaaamk","aaaaaaaaaaaaaaml","aaaaaaaaaaaaaamm","aaaaaaaaaaaaaamn","aaaaaaaaaaaaaamo","aaaaaaaaaaaaaamp","aaaaaaaaaaaaaamq","aaaaaaaaaaaaaamr","aaaaaaaaaaaaaams","aaaaaaaaaaaaaamt","aaaaaaaaaaaaaamu","aaaaaaaaaaaaaamv","aaaaaaaaaaaaaamw","aaaaaaaaaaaaaamx","aaaaaaaaaaaaaamy","aaaaaaaaaaaaaamz","aaaaaaaaaaaaaana","aaaaaaaaaaaaaanb","aaaaaaaaaaaaaanc","aaaaaaaaaaaaaand","aaaaaaaaaaaaaane","aaaaaaaaaaaaaanf","aaaaaaaaaaaaaang","aaaaaaaaaaaaaanh","aaaaaaaaaaaaaani","aaaaaaaaaaaaaanj","aaaaaaaaaaaaaank","aaaaaaaaaaaaaanl","aaaaaaaaaaaaaanm","aaaaaaaaaaaaaann","aaaaaaaaaaaaaano","aaaaaaaaaaaaaanp","aaaaaaaaaaaaaanq","aaaaaaaaaaaaaanr","aaaaaaaaaaaaaans","aaaaaaaaaaaaaant","aaaaaaaaaaaaaanu","aaaaaaaaaaaaaanv","aaaaaaaaaaaaaanw","aaaaaaaaaaaaaanx","aaaaaaaaaaaaaany","aaaaaaaaaaaaaanz","aaaaaaaaaaaaaaoa","aaaaaaaaaaaaaaob","aaaaaaaaaaaaaaoc","aaaaaaaaaaaaaaod","aaaaaaaaaaaaaaoe","aaaaaaaaaaaaaaof","aaaaaaaaaaaaaaog","aaaaaaaaaaaaaaoh","aaaaaaaaaaaaaaoi","aaaaaaaaaaaaaaoj","aaaaaaaaaaaaaaok","aaaaaaaaaaaaaaol","aaaaaaaaaaaaaaom","aaaaaaaaaaaaaaon","aaaaaaaaaaaaaaoo","aaaaaaaaaaaaaaop","aaaaaaaaaaaaaaoq","aaaaaaaaaaaaaaor","aaaaaaaaaaaaaaos","aaaaaaaaaaaaaaot","aaaaaaaaaaaaaaou","aaaaaaaaaaaaaaov","aaaaaaaaaaaaaaow","aaaaaaaaaaaaaaox","aaaaaaaaaaaaaaoy","aaaaaaaaaaaaaaoz","aaaaaaaaaaaaaapa","aaaaaaaaaaaaaapb","aaaaaaaaaaaaaapc","aaaaaaaaaaaaaapd","aaaaaaaaaaaaaape","aaaaaaaaaaaaaapf","aaaaaaaaaaaaaapg","aaaaaaaaaaaaaaph","aaaaaaaaaaaaaapi","aaaaaaaaaaaaaapj","aaaaaaaaaaaaaapk","aaaaaaaaaaaaaapl","aaaaaaaaaaaaaapm","aaaaaaaaaaaaaapn","aaaaaaaaaaaaaapo","aaaaaaaaaaaaaapp","aaaaaaaaaaaaaapq","aaaaaaaaaaaaaapr","aaaaaaaaaaaaaaps","aaaaaaaaaaaaaapt","aaaaaaaaaaaaaapu","aaaaaaaaaaaaaapv","aaaaaaaaaaaaaapw","aaaaaaaaaaaaaapx","aaaaaaaaaaaaaapy","aaaaaaaaaaaaaapz","aaaaaaaaaaaaaaqa","aaaaaaaaaaaaaaqb","aaaaaaaaaaaaaaqc","aaaaaaaaaaaaaaqd","aaaaaaaaaaaaaaqe","aaaaaaaaaaaaaaqf","aaaaaaaaaaaaaaqg","aaaaaaaaaaaaaaqh","aaaaaaaaaaaaaaqi","aaaaaaaaaaaaaaqj","aaaaaaaaaaaaaaqk","aaaaaaaaaaaaaaql","aaaaaaaaaaaaaaqm","aaaaaaaaaaaaaaqn","aaaaaaaaaaaaaaqo","aaaaaaaaaaaaaaqp","aaaaaaaaaaaaaaqq","aaaaaaaaaaaaaaqr","aaaaaaaaaaaaaaqs","aaaaaaaaaaaaaaqt","aaaaaaaaaaaaaaqu","aaaaaaaaaaaaaaqv","aaaaaaaaaaaaaaqw","aaaaaaaaaaaaaaqx","aaaaaaaaaaaaaaqy","aaaaaaaaaaaaaaqz","aaaaaaaaaaaaaara","aaaaaaaaaaaaaarb","aaaaaaaaaaaaaarc","aaaaaaaaaaaaaard","aaaaaaaaaaaaaare","aaaaaaaaaaaaaarf","aaaaaaaaaaaaaarg","aaaaaaaaaaaaaarh","aaaaaaaaaaaaaari","aaaaaaaaaaaaaarj","aaaaaaaaaaaaaark","aaaaaaaaaaaaaarl","aaaaaaaaaaaaaarm","aaaaaaaaaaaaaarn","aaaaaaaaaaaaaaro","aaaaaaaaaaaaaarp","aaaaaaaaaaaaaarq","aaaaaaaaaaaaaarr","aaaaaaaaaaaaaars","aaaaaaaaaaaaaart","aaaaaaaaaaaaaaru","aaaaaaaaaaaaaarv","aaaaaaaaaaaaaarw","aaaaaaaaaaaaaarx","aaaaaaaaaaaaaary","aaaaaaaaaaaaaarz","aaaaaaaaaaaaaasa","aaaaaaaaaaaaaasb","aaaaaaaaaaaaaasc","aaaaaaaaaaaaaasd","aaaaaaaaaaaaaase","aaaaaaaaaaaaaasf","aaaaaaaaaaaaaasg","aaaaaaaaaaaaaash","aaaaaaaaaaaaaasi","aaaaaaaaaaaaaasj","aaaaaaaaaaaaaask","aaaaaaaaaaaaaasl","aaaaaaaaaaaaaasm","aaaaaaaaaaaaaasn","aaaaaaaaaaaaaaso","aaaaaaaaaaaaaasp","aaaaaaaaaaaaaasq","aaaaaaaaaaaaaasr","aaaaaaaaaaaaaass","aaaaaaaaaaaaaast","aaaaaaaaaaaaaasu","aaaaaaaaaaaaaasv","aaaaaaaaaaaaaasw","aaaaaaaaaaaaaasx","aaaaaaaaaaaaaasy","aaaaaaaaaaaaaasz","aaaaaaaaaaaaaata","aaaaaaaaaaaaaatb","aaaaaaaaaaaaaatc","aaaaaaaaaaaaaatd","aaaaaaaaaaaaaate","aaaaaaaaaaaaaatf","aaaaaaaaaaaaaatg","aaaaaaaaaaaaaath","aaaaaaaaaaaaaati","aaaaaaaaaaaaaatj","aaaaaaaaaaaaaatk","aaaaaaaaaaaaaatl","aaaaaaaaaaaaaatm","aaaaaaaaaaaaaatn","aaaaaaaaaaaaaato","aaaaaaaaaaaaaatp","aaaaaaaaaaaaaatq","aaaaaaaaaaaaaatr","aaaaaaaaaaaaaats","aaaaaaaaaaaaaatt","aaaaaaaaaaaaaatu","aaaaaaaaaaaaaatv","aaaaaaaaaaaaaatw","aaaaaaaaaaaaaatx","aaaaaaaaaaaaaaty","aaaaaaaaaaaaaatz","aaaaaaaaaaaaaaua","aaaaaaaaaaaaaaub","aaaaaaaaaaaaaauc","aaaaaaaaaaaaaaud","aaaaaaaaaaaaaaue","aaaaaaaaaaaaaauf","aaaaaaaaaaaaaaug","aaaaaaaaaaaaaauh","aaaaaaaaaaaaaaui","aaaaaaaaaaaaaauj","aaaaaaaaaaaaaauk","aaaaaaaaaaaaaaul","aaaaaaaaaaaaaaum","aaaaaaaaaaaaaaun","aaaaaaaaaaaaaauo","aaaaaaaaaaaaaaup","aaaaaaaaaaaaaauq","aaaaaaaaaaaaaaur","aaaaaaaaaaaaaaus","aaaaaaaaaaaaaaut","aaaaaaaaaaaaaauu","aaaaaaaaaaaaaauv","aaaaaaaaaaaaaauw","aaaaaaaaaaaaaaux","aaaaaaaaaaaaaauy","aaaaaaaaaaaaaauz","aaaaaaaaaaaaaava","aaaaaaaaaaaaaavb","aaaaaaaaaaaaaavc","aaaaaaaaaaaaaavd","aaaaaaaaaaaaaave","aaaaaaaaaaaaaavf","aaaaaaaaaaaaaavg","aaaaaaaaaaaaaavh","aaaaaaaaaaaaaavi","aaaaaaaaaaaaaavj","aaaaaaaaaaaaaavk","aaaaaaaaaaaaaavl","aaaaaaaaaaaaaavm","aaaaaaaaaaaaaavn","aaaaaaaaaaaaaavo","aaaaaaaaaaaaaavp","aaaaaaaaaaaaaavq","aaaaaaaaaaaaaavr","aaaaaaaaaaaaaavs","aaaaaaaaaaaaaavt","aaaaaaaaaaaaaavu","aaaaaaaaaaaaaavv","aaaaaaaaaaaaaavw","aaaaaaaaaaaaaavx","aaaaaaaaaaaaaavy","aaaaaaaaaaaaaavz","aaaaaaaaaaaaaawa","aaaaaaaaaaaaaawb","aaaaaaaaaaaaaawc","aaaaaaaaaaaaaawd","aaaaaaaaaaaaaawe","aaaaaaaaaaaaaawf","aaaaaaaaaaaaaawg","aaaaaaaaaaaaaawh","aaaaaaaaaaaaaawi","aaaaaaaaaaaaaawj","aaaaaaaaaaaaaawk","aaaaaaaaaaaaaawl","aaaaaaaaaaaaaawm","aaaaaaaaaaaaaawn","aaaaaaaaaaaaaawo","aaaaaaaaaaaaaawp","aaaaaaaaaaaaaawq","aaaaaaaaaaaaaawr","aaaaaaaaaaaaaaws","aaaaaaaaaaaaaawt","aaaaaaaaaaaaaawu","aaaaaaaaaaaaaawv","aaaaaaaaaaaaaaww","aaaaaaaaaaaaaawx","aaaaaaaaaaaaaawy","aaaaaaaaaaaaaawz","aaaaaaaaaaaaaaxa","aaaaaaaaaaaaaaxb","aaaaaaaaaaaaaaxc","aaaaaaaaaaaaaaxd","aaaaaaaaaaaaaaxe","aaaaaaaaaaaaaaxf","aaaaaaaaaaaaaaxg","aaaaaaaaaaaaaaxh","aaaaaaaaaaaaaaxi","aaaaaaaaaaaaaaxj","aaaaaaaaaaaaaaxk","aaaaaaaaaaaaaaxl","aaaaaaaaaaaaaaxm","aaaaaaaaaaaaaaxn","aaaaaaaaaaaaaaxo","aaaaaaaaaaaaaaxp","aaaaaaaaaaaaaaxq","aaaaaaaaaaaaaaxr","aaaaaaaaaaaaaaxs","aaaaaaaaaaaaaaxt","aaaaaaaaaaaaaaxu","aaaaaaaaaaaaaaxv","aaaaaaaaaaaaaaxw","aaaaaaaaaaaaaaxx","aaaaaaaaaaaaaaxy","aaaaaaaaaaaaaaxz","aaaaaaaaaaaaaaya","aaaaaaaaaaaaaayb","aaaaaaaaaaaaaayc","aaaaaaaaaaaaaayd","aaaaaaaaaaaaaaye","aaaaaaaaaaaaaayf","aaaaaaaaaaaaaayg","aaaaaaaaaaaaaayh","aaaaaaaaaaaaaayi","aaaaaaaaaaaaaayj","aaaaaaaaaaaaaayk","aaaaaaaaaaaaaayl","aaaaaaaaaaaaaaym","aaaaaaaaaaaaaayn","aaaaaaaaaaaaaayo","aaaaaaaaaaaaaayp","aaaaaaaaaaaaaayq","aaaaaaaaaaaaaayr","aaaaaaaaaaaaaays","aaaaaaaaaaaaaayt","aaaaaaaaaaaaaayu","aaaaaaaaaaaaaayv","aaaaaaaaaaaaaayw","aaaaaaaaaaaaaayx","aaaaaaaaaaaaaayy","aaaaaaaaaaaaaayz","aaaaaaaaaaaaaaza","aaaaaaaaaaaaaazb","aaaaaaaaaaaaaazc","aaaaaaaaaaaaaazd","aaaaaaaaaaaaaaze","aaaaaaaaaaaaaazf","aaaaaaaaaaaaaazg","aaaaaaaaaaaaaazh","aaaaaaaaaaaaaazi","aaaaaaaaaaaaaazj","aaaaaaaaaaaaaazk","aaaaaaaaaaaaaazl","aaaaaaaaaaaaaazm","aaaaaaaaaaaaaazn","aaaaaaaaaaaaaazo","aaaaaaaaaaaaaazp","aaaaaaaaaaaaaazq","aaaaaaaaaaaaaazr","aaaaaaaaaaaaaazs","aaaaaaaaaaaaaazt","aaaaaaaaaaaaaazu","aaaaaaaaaaaaaazv","aaaaaaaaaaaaaazw","aaaaaaaaaaaaaazx","aaaaaaaaaaaaaazy","aaaaaaaaaaaaaazz","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaaan","aaaaaaaaaaaaaaao","aaaaaaaaaaaaaaap","aaaaaaaaaaaaaaaq","aaaaaaaaaaaaaaar","aaaaaaaaaaaaaaas","aaaaaaaaaaaaaaat","aaaaaaaaaaaaaaau","aaaaaaaaaaaaaaav","aaaaaaaaaaaaaaaw","aaaaaaaaaaaaaaax","aaaaaaaaaaaaaaay","aaaaaaaaaaaaaaaz","aaaaaaaaaaaaaaba","aaaaaaaaaaaaaabb","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabd","aaaaaaaaaaaaaabe","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaabg","aaaaaaaaaaaaaabh","aaaaaaaaaaaaaabi","aaaaaaaaaaaaaabj","aaaaaaaaaaaaaabk","aaaaaaaaaaaaaabl","aaaaaaaaaaaaaabm","aaaaaaaaaaaaaabn","aaaaaaaaaaaaaabo","aaaaaaaaaaaaaabp","aaaaaaaaaaaaaabq","aaaaaaaaaaaaaabr","aaaaaaaaaaaaaabs","aaaaaaaaaaaaaabt","aaaaaaaaaaaaaabu","aaaaaaaaaaaaaabv","aaaaaaaaaaaaaabw","aaaaaaaaaaaaaabx","aaaaaaaaaaaaaaby","aaaaaaaaaaaaaabz","aaaaaaaaaaaaaaca","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacc","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaace","aaaaaaaaaaaaaacf","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaach","aaaaaaaaaaaaaaci","aaaaaaaaaaaaaacj","aaaaaaaaaaaaaack","aaaaaaaaaaaaaacl","aaaaaaaaaaaaaacm","aaaaaaaaaaaaaacn","aaaaaaaaaaaaaaco","aaaaaaaaaaaaaacp","aaaaaaaaaaaaaacq","aaaaaaaaaaaaaacr","aaaaaaaaaaaaaacs","aaaaaaaaaaaaaact","aaaaaaaaaaaaaacu","aaaaaaaaaaaaaacv","aaaaaaaaaaaaaacw","aaaaaaaaaaaaaacx","aaaaaaaaaaaaaacy","aaaaaaaaaaaaaacz","aaaaaaaaaaaaaada","aaaaaaaaaaaaaadb","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaadd","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadf","aaaaaaaaaaaaaadg","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaadi","aaaaaaaaaaaaaadj","aaaaaaaaaaaaaadk","aaaaaaaaaaaaaadl","aaaaaaaaaaaaaadm","aaaaaaaaaaaaaadn","aaaaaaaaaaaaaado","aaaaaaaaaaaaaadp","aaaaaaaaaaaaaadq","aaaaaaaaaaaaaadr","aaaaaaaaaaaaaads","aaaaaaaaaaaaaadt","aaaaaaaaaaaaaadu","aaaaaaaaaaaaaadv","aaaaaaaaaaaaaadw","aaaaaaaaaaaaaadx","aaaaaaaaaaaaaady","aaaaaaaaaaaaaadz","aaaaaaaaaaaaaaea","aaaaaaaaaaaaaaeb","aaaaaaaaaaaaaaec","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaee","aaaaaaaaaaaaaaef","aaaaaaaaaaaaaaeg","aaaaaaaaaaaaaaeh","aaaaaaaaaaaaaaei","aaaaaaaaaaaaaaej","aaaaaaaaaaaaaaek","aaaaaaaaaaaaaael","aaaaaaaaaaaaaaem","aaaaaaaaaaaaaaen","aaaaaaaaaaaaaaeo","aaaaaaaaaaaaaaep","aaaaaaaaaaaaaaeq","aaaaaaaaaaaaaaer","aaaaaaaaaaaaaaes","aaaaaaaaaaaaaaet","aaaaaaaaaaaaaaeu","aaaaaaaaaaaaaaev","aaaaaaaaaaaaaaew","aaaaaaaaaaaaaaex","aaaaaaaaaaaaaaey","aaaaaaaaaaaaaaez","aaaaaaaaaaaaaafa","aaaaaaaaaaaaaafb","aaaaaaaaaaaaaafc","aaaaaaaaaaaaaafd","aaaaaaaaaaaaaafe","aaaaaaaaaaaaaaff","aaaaaaaaaaaaaafg","aaaaaaaaaaaaaafh","aaaaaaaaaaaaaafi","aaaaaaaaaaaaaafj","aaaaaaaaaaaaaafk","aaaaaaaaaaaaaafl","aaaaaaaaaaaaaafm","aaaaaaaaaaaaaafn","aaaaaaaaaaaaaafo","aaaaaaaaaaaaaafp","aaaaaaaaaaaaaafq","aaaaaaaaaaaaaafr","aaaaaaaaaaaaaafs","aaaaaaaaaaaaaaft","aaaaaaaaaaaaaafu","aaaaaaaaaaaaaafv","aaaaaaaaaaaaaafw","aaaaaaaaaaaaaafx","aaaaaaaaaaaaaafy","aaaaaaaaaaaaaafz","aaaaaaaaaaaaaaga","aaaaaaaaaaaaaagb","aaaaaaaaaaaaaagc","aaaaaaaaaaaaaagd","aaaaaaaaaaaaaage","aaaaaaaaaaaaaagf","aaaaaaaaaaaaaagg","aaaaaaaaaaaaaagh","aaaaaaaaaaaaaagi","aaaaaaaaaaaaaagj","aaaaaaaaaaaaaagk","aaaaaaaaaaaaaagl","aaaaaaaaaaaaaagm","aaaaaaaaaaaaaagn","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq","aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu","aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy","aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc","aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg","aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaahj","aaaaaaaaaaaaaahk","aaaaaaaaaaaaaahl","aaaaaaaaaaaaaahm","aaaaaaaaaaaaaahn","aaaaaaaaaaaaaaho","aaaaaaaaaaaaaahp","aaaaaaaaaaaaaahq","aaaaaaaaaaaaaahr","aaaaaaaaaaaaaahs","aaaaaaaaaaaaaaht","aaaaaaaaaaaaaahu","aaaaaaaaaaaaaahv","aaaaaaaaaaaaaahw","aaaaaaaaaaaaaahx","aaaaaaaaaaaaaahy","aaaaaaaaaaaaaahz","aaaaaaaaaaaaaaia","aaaaaaaaaaaaaaib","aaaaaaaaaaaaaaic","aaaaaaaaaaaaaaid","aaaaaaaaaaaaaaie","aaaaaaaaaaaaaaif","aaaaaaaaaaaaaaig","aaaaaaaaaaaaaaih","aaaaaaaaaaaaaaii","aaaaaaaaaaaaaaij","aaaaaaaaaaaaaaik","aaaaaaaaaaaaaail","aaaaaaaaaaaaaaim","aaaaaaaaaaaaaain","aaaaaaaaaaaaaaio","aaaaaaaaaaaaaaip","aaaaaaaaaaaaaaiq","aaaaaaaaaaaaaair","aaaaaaaaaaaaaais","aaaaaaaaaaaaaait","aaaaaaaaaaaaaaiu","aaaaaaaaaaaaaaiv","aaaaaaaaaaaaaaiw","aaaaaaaaaaaaaaix","aaaaaaaaaaaaaaiy","aaaaaaaaaaaaaaiz","aaaaaaaaaaaaaaja","aaaaaaaaaaaaaajb","aaaaaaaaaaaaaajc","aaaaaaaaaaaaaajd","aaaaaaaaaaaaaaje","aaaaaaaaaaaaaajf","aaaaaaaaaaaaaajg","aaaaaaaaaaaaaajh","aaaaaaaaaaaaaaji","aaaaaaaaaaaaaajj","aaaaaaaaaaaaaajk","aaaaaaaaaaaaaajl","aaaaaaaaaaaaaajm","aaaaaaaaaaaaaajn","aaaaaaaaaaaaaajo","aaaaaaaaaaaaaajp","aaaaaaaaaaaaaajq","aaaaaaaaaaaaaajr","aaaaaaaaaaaaaajs","aaaaaaaaaaaaaajt","aaaaaaaaaaaaaaju","aaaaaaaaaaaaaajv","aaaaaaaaaaaaaajw","aaaaaaaaaaaaaajx","aaaaaaaaaaaaaajy","aaaaaaaaaaaaaajz","aaaaaaaaaaaaaaka","aaaaaaaaaaaaaakb","aaaaaaaaaaaaaakc","aaaaaaaaaaaaaakd","aaaaaaaaaaaaaake","aaaaaaaaaaaaaakf","aaaaaaaaaaaaaakg","aaaaaaaaaaaaaakh","aaaaaaaaaaaaaaki","aaaaaaaaaaaaaakj","aaaaaaaaaaaaaakk","aaaaaaaaaaaaaakl","aaaaaaaaaaaaaakm","aaaaaaaaaaaaaakn","aaaaaaaaaaaaaako","aaaaaaaaaaaaaakp","aaaaaaaaaaaaaakq","aaaaaaaaaaaaaakr","aaaaaaaaaaaaaaks","aaaaaaaaaaaaaakt","aaaaaaaaaaaaaaku","aaaaaaaaaaaaaakv","aaaaaaaaaaaaaakw","aaaaaaaaaaaaaakx","aaaaaaaaaaaaaaky","aaaaaaaaaaaaaakz","aaaaaaaaaaaaaala","aaaaaaaaaaaaaalb","aaaaaaaaaaaaaalc","aaaaaaaaaaaaaald","aaaaaaaaaaaaaale","aaaaaaaaaaaaaalf","aaaaaaaaaaaaaalg","aaaaaaaaaaaaaalh","aaaaaaaaaaaaaali","aaaaaaaaaaaaaalj","aaaaaaaaaaaaaalk","aaaaaaaaaaaaaall"}));
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\test.txt"));
        String strs = br.readLine();
        String[] ss = strs.split(",");
        for(int i=0;i<ss.length;i++)
            ss[i] = ss[i].replace("\"", "");
        List<String> result = new Number212().findWords(board, ss);
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(result);
    }
}
