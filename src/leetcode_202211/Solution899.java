package leetcode_202211;

public class Solution899 {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("baaca", 3));
    }
    public static String orderlyQueue(String S, int K) {
        int[] cs = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()){
            cs[c - 'a']++;
        }
        int index = -1;
        for(int i = 0; i < 26 && index == -1; i++){
            if(cs[i] > 0){
                while(cs[i] > 0){
                    cs[i]--;
                    sb.append((char)('a' + i));
                    if(K == 1){
                        index = S.indexOf((char)('a' + i));
                        break;
                    }

                }
            }
        }
        if(K == 1){
            sb = new StringBuilder();
            while(index != -1){
                StringBuilder current = new StringBuilder();
                current.append(S.charAt(index));
                current.append(S.substring(index + 1));
                current.append(S, 0, index);
                if(sb.length() == 0 || sb.toString().compareTo(current.toString()) > 0)
                    sb = current;
                index = S.indexOf(S.charAt(index), index + 1);
            }
        }
        return sb.toString();
    }
}
