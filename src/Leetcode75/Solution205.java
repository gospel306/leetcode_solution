package Leetcode75;

import java.util.HashMap;

public class Solution205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), t.charAt(0));
        for(int i = 1;i < s.length();i++) {
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }else if(map.containsValue(t.charAt(i))){
                    return false;
                }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
