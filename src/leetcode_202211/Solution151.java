package leetcode_202211;

public class Solution151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good      example"));
    }

    public static String reverseWords(String s){
        String[] strings = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for(String string : strings){
            if(!string.equals("")){
                answer.insert(0, string + " ");
            }
        }
        return answer.toString().trim();
    }
}
