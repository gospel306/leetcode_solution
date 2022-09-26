package leetcode_202209;

import java.util.Arrays;

public class Solution990 {
    /*
    You are given an array of strings equations that represent relationships between variables
    where each string equations[i] is of length 4 and takes one of two different forms:
    "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different)
    that represent one-letter variable names.

    Return true if it is possible to assign integers to variable names
    so as to satisfy all the given equations, or false otherwise.

    Example 1:
    Input: equations = ["a==b","b!=a"]
    Output: false
    Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
    There is no way to assign the variables to satisfy both equations.

    Example 2:
    Input: equations = ["b==a","a==b"]
    Output: true
    Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

    Constraints:
    1 <= equations.length <= 500
    equations[i].length == 4
    equations[i][0] is a lowercase letter.
    equations[i][1] is either '=' or '!'.
    equations[i][2] is '='.
    equations[i][3] is a lowercase letter.
     */

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations));
    }
    public static int[] vector = new int[26];
    public static boolean equationsPossible(String[] equations) {
        Arrays.fill(vector, -1);
        for(String equation : equations){
            if(checkEqualSign(equation.charAt(1)))
                merge(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }
        for (String equation : equations){
            if(checkEqualSign(equation.charAt(1)))
                continue;
            if(!answer(equation.charAt(0) - 'a', equation.charAt(3) - 'a'))
                return false;
        }
        return true;
    }

    private static int find(int x){
        return vector[x] == -1 || vector[x] == x ? x : find(vector[x]);
    }

    private static void merge(int x, int y){
        vector[find(x)] = find(y);
    }

    private static boolean answer(int x, int y){
        return find(x) != find(y);
    }

    private static boolean checkEqualSign(char sign){
        return sign == '=' ? true : false;
    }

}
