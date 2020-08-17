package bite13.泛型;

import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/3/13 16:22
 * @Description:
 */
public class Template<E,K,V> {

}
class MyArrayList<E>{
    private E[] array;
    private int size;
    private int capacity;

    public MyArrayList(){
        array = (E[]) new Object[10];
        size = 0;
        capacity = 10;
    }
    public void add(E value){
        if(size == capacity){
            array = Arrays.copyOf(array,2*capacity);
            capacity *=2;
        }
        array[size++] = value;
    }
    public E remove(){
        E ret;
        if(size>0){
            ret = array[size-1];
            array[size-1] = null;
            --size;
            return ret;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void print(){
        for(E e:array){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> mL = new MyArrayList<>();
        MyArrayList<Character> mL2 = new MyArrayList<>();
        mL.add(1);
        mL.add(2);
        mL.add(3);
        mL.add(4);
        mL.print();

        mL2.add('a');
        mL2.add('b');
        mL2.add('c');
        mL2.add('d');
        mL2.print();
    }
}
class MyList<E extends Number>{
    //静态成员不能定义泛型
    //非静态内部内可以使用外部类的泛型参数
    //静态内部类不能使用外部类的泛型参数，需要自己定义
    private static class Node<E>{
        private E value;
        Node<E> next;
        private Node(E value){
            this.value = value;
            next = null;
        }
    }
    private Node<E> head = null;

    private void pushFront(E value){
        if(head == null)
            head = new Node<>(value);
        else {
            Node<E> node = new Node<>(value);
            node.next = head;
            head = node;
        }
    }
    private E pushPop(){
        E ret = head.value;
        head = head.next;
        return ret;
    }
    //? 的使用规则
    public static  void fun1(MyList<?> m1){

    }
    //指定上界
    public static void fun2(MyList<? extends Number> m2){

    }
    //指定下界
    public static void fun3(MyList<? super Integer> m3){

    }
    //超出上下界就会出现报错
    public static void main(String[] args) {

    }
}
class A implements Comparable<A>{

    @Override
    public int compareTo(A o) {
        return 0;
    }
}
class C{

}
class B<E extends Comparable<E>,T>{
    public static void main(String[] args) {
        B<Integer, Character> b = new B<>();
       // B<C, Character> c = new B<>();//报错原因：C不属于她的上界范围之内
        B<A, Character> d = new B<>();
    }
}