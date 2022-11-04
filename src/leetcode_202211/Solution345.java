package leetcode_202211;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution345 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(reverseVowels("leetcode"));
    }
    public static String reverseVowels(String s){
        char[] chars = s.toCharArray();
        ArrayList<Pair> pairs = new ArrayList<>();
        char[] vowels = {'a','e','i','o','u', 'A','E','I','O','U'};
        for(int i = 0;i < chars.length;i++){
            for(char vowel:vowels){
                if(chars[i] == vowel){
                    pairs.add(new Pair(chars[i], i));
                    break;
                }
            }
        }
        for(int i = 0;i < pairs.size();i++){
            chars[pairs.get(i).i] = pairs.get(pairs.size() - i - 1).c;
        }
        return new String(chars);
    }
    static class Pair{
        char c;
        int i;
        public Pair(char c, int i){
            this.c = c;
            this.i = i;
        }
    }
}
