package bite08.泛型;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/13 11:29
 * @Description: 泛型在编译时期
 */
public class MyArrayList<E> {
    private E[] array;
    private int size;

    MyArrayList(){
        array = (E[]) new Object[10];
        size = 0;
    }
    public void add(E element){
        array[size++] = element;
    }
    public E get(int index){
        return array[index];
    }

    public static void main(String[] args) {

    }
}
