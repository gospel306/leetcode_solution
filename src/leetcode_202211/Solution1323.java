package leetcode_202211;

public class Solution1323 {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
    public static int maximum69Number (int num){
        int[] num_arr = new int[4];
        int result_num = num;
        boolean isSwap = false;
        for(int i=0; i<num_arr.length; i++) {
            num_arr[i] = result_num % 10;
            result_num = result_num / 10;
        }
        for(int i=(num_arr.length-1); i>=0; i--) {
            if(num_arr[i] == 6 && !isSwap) {
                num_arr[i] = 9;
                isSwap = true;
            }
            result_num += num_arr[i];
            if(i > 0) {
                result_num *= 10;
            }
        }
        return result_num;
    }
}
