package leetcode_202211;

public class Solution1544 {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
    public static String makeGood(String s){

        for(int i = 0;i < s.length() - 1;i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            String tmp = s;
            if(c1 == (c2 - 32) || c1 == (c2 + 32)){
                s = tmp.substring(0, i);
                if(i + 2 < tmp.length())
                    s += tmp.substring(i + 2);
                if(i == 0)
                    i--;
                else
                    i-= 2;
            }
        }
        return s;
    }
}
