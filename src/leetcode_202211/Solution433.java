package leetcode_202211;

import java.util.LinkedList;
import java.util.Queue;

public class Solution433 {
    public static void main(String[] args) {
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank));
    }

    public static int minMutation(String start, String end, String[] bank){
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];
        queue.add(new Pair(start, 0));
        while (!queue.isEmpty()){
            Pair pair = queue.poll();

            if(pair.mutate.equals(end))
                return pair.cnt;

            for(int i = 0;i < bank.length;i++){
                if(!visited[i] && isOneDiff(pair.mutate, bank[i])){
                    visited[i] = true;
                    queue.add(new Pair(bank[i], pair.cnt + 1));
                }
            }
        }
        return -1;
    }

    private static boolean isOneDiff(String first, String second){
        int cnt = 0;
        for(int i = 0;i < first.length();i++){
            if(first.charAt(i) != second.charAt(i))
                cnt++;
        }
        return cnt == 1 ? true : false;
    }

    static class Pair{
        String mutate;
        int cnt;

        public Pair(String mutate, int cnt){
            this.mutate = mutate;
            this.cnt = cnt;
        }
    }
}
