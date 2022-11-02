package Leetcode75;

import java.util.Arrays;

public class Solution1480 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums){
        for (int i = 1;i < nums.length;i++){
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
