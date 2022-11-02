package Leetcode75;

public class Solution392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t){
        int cnt = 0;
        int pivot = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = pivot;j < t.length();j++){
                if(s.charAt(i) == t.charAt(j)){
                    pivot = j + 1;
                    cnt++;
                    break;
                }
            }
        }
        return cnt == s.length() ? true : false;
    }
}
