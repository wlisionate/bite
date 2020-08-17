package bite07.接口连同抽象类;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/12 15:20
 * @Description:
 */
public interface MyList {
    void pushFront(int element);
    void pushBack(int element);
    void insert(int index,int element);
}
abstract class AbstractList implements MyList{
    protected int size;

    @Override
    public void pushFront(int element) {
        insert(0,element);
    }

    @Override
    public void pushBack(int element) {
        insert(size,element);
    }
}
class MyArrayList extends AbstractList{

    @Override
    public void insert(int index, int element) {

    }
}
class MyLinkedList extends AbstractList{

    @Override
    public void insert(int index, int element) {

    }
}