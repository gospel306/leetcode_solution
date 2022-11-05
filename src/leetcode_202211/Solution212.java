package leetcode_202211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution212 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(Arrays.toString(findWords(board,words).toArray()));
    }
    private static List<String> answer;
    public static List<String> findWords(char[][] board, String[] words){
        answer = new ArrayList<>();
        if(board == null || board[0].length == 0)
            return answer;
        TrieNode root = new TrieNode();
        buildTrie(root, words);

        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                int idx = board[i][j] - 'a';
                if(root.children[idx] != null)
                    dfs(board, root, i, j);
            }
        }
        return answer;
    }

    private static void dfs(char[][] board, TrieNode node, int i, int j){
        if(node.word != null){
            answer.add(node.word);
            node.word = null;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#')
            return;
        char tmp = board[i][j];
        int idx = board[i][j] - 'a';
        if(node.children[idx] == null)
            return;

        board[i][j] = '#';
        dfs(board, node.children[idx], i, j + 1);
        dfs(board, node.children[idx], i, j - 1);
        dfs(board, node.children[idx], i + 1, j);
        dfs(board, node.children[idx], i - 1, j);

        board[i][j] = tmp;
    }

    private static void buildTrie(TrieNode root, String[] words){
        for(String s: words){
            TrieNode node = root;
            for(char c : s.toCharArray()){
                int idx = c - 'a';
                if(node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = s;
        }
    }

    static class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }
}
