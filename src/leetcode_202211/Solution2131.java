package leetcode_202211;

import java.util.HashMap;

public class Solution2131 {
    public static void main(String[] args) {

    }
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> stringCnt = new HashMap<>();
        int res = 0;
        int self = 0;
        for (String word : words) {
            char c1 = word.charAt(0);
            char c2 = word.charAt(1);
            if (stringCnt.containsKey(word)) {
                res += 4;
                stringCnt.put(word, stringCnt.get(word) - 1);
                if (stringCnt.get(word) == 0)
                    stringCnt.remove(word);
                if (c1 == c2)
                    self--;
            } else if (c1 == c2) {
                stringCnt.put(word, 1);
                self++;
            } else {
                String reverse = "" + c2 + c1;
                if (!stringCnt.containsKey(reverse))
                    stringCnt.put(reverse, 1);
                else
                    stringCnt.put(reverse, stringCnt.get(reverse) + 1);
            }
        }
        if(self > 0)
            res += 2;
        return res;
    }
}
