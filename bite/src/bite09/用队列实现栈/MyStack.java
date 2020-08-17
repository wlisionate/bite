package bite09.用队列实现栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 11:35
 * @Description:
 */
public class MyStack {
     static Queue<Integer> queue ;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int a = queue.poll();
            list.add(a);
        }
        for(int i=0;i<list.size()-1;i++){
            queue.offer(list.get(i));
        }
        return list.get(list.size()-1);
    }

    /** Get the top element. */
    public int top() {
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int a = queue.poll();
            list.add(a);
        }
        for(int i=0;i<list.size();i++){
            queue.offer(list.get(i));
        }
        return list.get(list.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
