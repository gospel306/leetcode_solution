package leetcode_202211;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
