package bite05;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/8 10:25
 * @Description: 顺序表
 */
public class MyArrayList {
    private int [] array;
    private int size;
    public MyArrayList(){
        array = new int[10];
        size = 0;
    }
    //尾插
    public void pushBack(int element){
        array[size] = element;
        size++;
    }
    //尾删
    public void popBack(){
        array[--size] = 0;
    }
    //头插
    public void pushFront(int element){
        for(int i=size-1;i>=0;i--){
            //array[空心] = array[实心];
            array[i+1] = array[i];
        }
        array[0] = element;
        size++;
    }
    //头删
    public void popFront(){
        for(int i=1;i<=size-1;i++){
            array[i-1] = array[i];
        }
        array[size-1] = 0;
        size--;
    }
    //根据下标进行插入和删除
    //插入
    public void push(int element,int index){
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }
    //删除
    public void pop(int index){
        for(int i=index;i<size-1;i++){
            array[i] = array[i+1];
        }
        array[size-1] = 0;
        size--;
    }
    //进行容量的检查
    private boolean checkCapacity(int num){
        return size+num <= array.length;
    }
    //进行容量的扩充，直接进行两倍扩充
    private void ensureCapacity(){
        int newLength = array.length*2;
        int [] newArray = new int[newLength];
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        System.out.println(list);
        list.push(4,3);
//        list.popFront();
//        list.popFront();
        System.out.println(list);
        list.pop(3);
        System.out.println(list);
//        list.popBack();
//        System.out.println(list);
//        list.popBack();
//        list.popBack();
//        System.out.println(list);
    }
}
