import java.util.*;

public class Solution {

    public static void main(String[] args){

    }

    //求每个单词的nexts，也就是可以由其他串变换一个字符成为他自己的即为该单词的next
    public static ArrayList<String> getNext(String word, Set<String> set){
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for(int i = 0;i < chs.length;i++){
            for(char cur = 'a'; cur <= 'z'; cur++){
                if(chs[i] != 'a'){
                    char temp = chs[i];
                    chs[i] = cur;
                    if(set.contains(String.valueOf(chs))){
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = temp;
                }
            }
        }
        return res;
    }


    //为每个单词生成他们的相邻的单词的list
    public static HashMap<String, ArrayList<String>> getNexts(List<String> words){
        HashSet<String> set = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for(int i=0;i < words.size(); i++){
            nexts.put(words.get(i),new ArrayList<String>());
        }
        for(int i=0;i < words.size(); i++){
            nexts.put(words.get(i),getNext(words.get(i), set));
        }
        return nexts;
    }


    // 广度优先遍历（宽度优先遍历）,生成每个单词相对于bengin单词的距离是，两个相邻则两个单词的距离为1
    public HashMap<String,Integer> getDistances(String bengin, HashMap<String, ArrayList<String>> nexts){
        HashMap<String, Integer> distances = new HashMap<>();
        Queue<String> queue = new LinkedList<String>();
        distances.put(bengin, 0);
        queue.add(bengin);
        HashSet<String> isVisit = new HashSet<>();
        while(!queue.isEmpty()){
            String cur = queue.poll();
            for(String str: nexts.get(cur)){
                if(!isVisit.contains(str)){
                    distances.put(str, distances.get(cur) + 1);
                    queue.add(str);
                    isVisit.add(str);
                }
            }
        }
        return distances;
    }

    public static void getShortPath(String cur, String end, HashMap<String, ArrayList<String>> nexts,
                                HashMap<String, Integer> disance, LinkedList<String> solutions,
                                    List<List<String>> res){

        solutions.add(cur);
        if(end.equals(cur)){
            res.add(new LinkedList<>(solutions));
        }else{
            for(String next:nexts.get(cur)){
                if(disance.get(next) == disance.get(cur) + 1){
                    getShortPath(next, end, nexts, disance, solutions, res);
                }
            }
        }
        // 如果没有找到，solution中弹出最后一个字符串
        solutions.pollLast();
    }
}
