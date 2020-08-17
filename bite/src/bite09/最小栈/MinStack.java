package bite09.最小栈;

import java.util.Stack;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 14:46
 * @Description:
 */
public class MinStack {
    Stack<Integer> stack1;
     Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack1.push(x);
        if(stack1.peek()<=stack2.peek()){
            stack2.push(stack1.peek());
        }
    }

    public void pop() {
        if(stack1.peek() == stack2.peek()){
            stack1.pop();
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
