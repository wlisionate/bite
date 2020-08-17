package bite09.栈的实现;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/14 15:28
 * @Description:
 */
public class Stack {
    private int[] array;
    private int size;
    public Stack(int n){
        array = new int[n];
        size = 0;
    }
    public void push(int value){
        if(size == array.length){
            array = Arrays.copyOf(array,2*size);
        }
        array[size++] = value;
    }
    public int pop(){
        int a = array[size-1];
        if(size>0)
            size--;
        return a;
    }
    public int peek(){
        return array[size-1];
    }
    public int size(){
        return size;
    }
    public boolean empty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
