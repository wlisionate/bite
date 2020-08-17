package bite09;

import java.util.Stack;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 09:54
 * @Description:
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.empty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
