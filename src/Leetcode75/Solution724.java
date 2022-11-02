package Leetcode75;

public class Solution724 {
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums){
        for (int i = 0;i < nums.length;i++){
            int pivot = i;
            int sumLeft = 0;
            int sumRight = 0;
            for(int left = pivot - 1;left >= 0;left--)
                sumLeft += nums[left];
            for(int right = pivot + 1;right < nums.length;right++)
                sumRight += nums[right];
            if(sumLeft == sumRight)
                return pivot;
        }
        return -1;
    }
}
