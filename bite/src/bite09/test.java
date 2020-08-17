//package bite09;
//
//import java.util.Stack;
//
///**
// * ⊙﹏⊙&&&&&&⊙▽⊙
// *
// * @Auther: pangchenbo
// * @Date: 2020/1/14 09:16
// * @Description:
// */
//public class test {
//}
//class Solution {
//    public boolean backspaceCompare(String S, String T) {
//        return build(S).equals(build(T));
//    }
//    public static String build(String s){
//        Stack<Character> stack = new Stack<>();
//        for (char c: s.toCharArray()){
//            if(c != '#')
//                stack.push(c);
//            else if(!stack.isEmpty())
//                stack.pop();
//        }
//        return String.valueOf(stack);
//    }
//}
//class Solution {
//    public int calPoints(String[] ops) {
//        Stack<Integer> stack = new Stack();
//
//        for(String op : ops) {
//            if (op.equals("+")) {
//                int top = stack.pop();
//                int newtop = top + stack.peek();
//                stack.push(top);
//                stack.push(newtop);
//            } else if (op.equals("C")) {
//                stack.pop();
//            } else if (op.equals("D")) {
//                stack.push(2 * stack.peek());
//            } else {
//                stack.push(Integer.valueOf(op));
//            }
//        }
//
//        int ans = 0;
//        for(int score : stack) ans += score;
//        return ans;
//    }
//}
//class Solution {
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for(String c:tokens){
//            if(c.equals("+")){
//                stack.push(stack.pop()+stack.pop());
//            }else if(c.equals("-")){
//                stack.push(stack.pop()-stack.pop());
//            }else if(c.equals("*")){
//                stack.push(stack.pop()*stack.pop());
//            }else if (c.equals("/")){
//                stack.push(stack.pop()/stack.pop());
//            }else
//                stack.push(Integer.valueOf(c));
//        }
//        return stack.pop();
//    }
//}
//
