package leetcode_202209;

import java.util.Arrays;

public class Solution2007 {
    public static void main(String[] args) {
        int[] changed = {1,3,4,2,6,8};
        System.out.println(Arrays.toString(findOriginalArray(changed)));
    }

    public static int[] findOriginalArray(int[] changed){
        if(changed.length % 2 != 0)
            return new int[]{};
        int mid = changed.length/2;
        int[] ans = new int[mid];
        int[] freq = new int[100001];

        for(int num:changed)
            freq[num]++;
        int id = 0;
        for (int n = 0;n < freq.length;n++){
            while (freq[n] > 0 && n * 2 < 100001 && freq[n * 2] > 0){
                freq[n]--;
                freq[n*2]--;
                if(freq[n*2] < 0)
                    return new int[]{};
                ans[id] = n;
                id++;
            }
        }
        for(int i = 0;i < freq.length;i++) {
            if (freq[i] != 0)
                return new int[]{};
        }
        return ans;
    }
}
