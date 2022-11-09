package leetcode_202211;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution901 {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int[] nextList = {100,80,60,70,60,75,85};
        for(int next : nextList)
            System.out.println(obj.next(next));
    }
}

class StockSpanner{
    private Stack<Info> list;
    public StockSpanner(){
        list = new Stack<>();
    }

    public int next(int price){
        int cnt = 1;
        for(int i = list.size() - 1;i >= 0;i--){
            if(list.peek().price > price)
                break;
            cnt += list.pop().cnt;
        }
        list.push(new Info(price, cnt));
        return list.peek().cnt;
    }

    class Info{
        int price;
        int cnt;
        public Info(int price, int cnt){
            this.price = price;
            this.cnt = cnt;
        }
    }
}
