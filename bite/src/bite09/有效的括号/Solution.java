package bite09.有效的括号;

import java.util.Stack;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 10:11
 * @Description:
 */
public class Solution {
    public boolean isValid(String s) {
        if(s==null){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(!stack.empty()&&((c==')'&& stack.peek()=='(')||(c==']'&& stack.peek()=='[')||(c=='}'&& stack.peek()=='{'))){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
