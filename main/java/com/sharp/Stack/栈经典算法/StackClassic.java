package com.sharp.Stack.栈经典算法;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StackClassic {
    /**
     * 括号匹配问题
     * LeetCode20. 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例1：
     * 输入：s = "()[]{}"
     * 输出：true
     * 方法 ：栈 + 哈希表
     * 用哈希表将所有符号先存储，左半边做key,右半边做value。遍历字符串的时候，遇到左半边符号就入栈，
     * 遇到右半边符号就与栈顶的符号比较，不匹配就返回false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length() % 2 == 1 ){
            return false;
        }
        Map<Character,Character> smap = new HashMap<>();
        smap.put('(',')');
        smap.put('[',']');
        smap.put('{','}');
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char item = s.charAt(i);
            if(smap.containsKey(item)){
                stack.push(item);
            }else{
                if(!stack.isEmpty()){
                    Character left = stack.pop();
                    char right = smap.get(left);
                    if(right != item){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}






















