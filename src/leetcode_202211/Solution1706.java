package leetcode_202211;

import java.util.Arrays;

public class Solution1706 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}, {1,1,1,1,1,1}, {-1,-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(findBall(grid)));
    }
    public static int[] findBall(int[][] grid){
        int[] answer = new int[grid[0].length];
        for(int i = 0;i < grid[0].length;i++){
            answer[i] = findBallDropColumn(grid, 0, i);
        }
        return answer;
    }

    private static int findBallDropColumn(int[][] grid, int row, int col){
        if(row == grid.length){
            return col;
        }
        int nextColumn = col + grid[row][col];
        if(nextColumn < 0 || nextColumn >= grid[0].length || grid[row][col] != grid[row][nextColumn])
            return -1;
        return findBallDropColumn(grid, row + 1, nextColumn);
    }
}
