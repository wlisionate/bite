package bite05;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/8 11:58
 * @Description:
 */
public class useArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(100);
        list.add("hello");
        //给具体位置下标插入值
        list.add(0,"world");
        System.out.println(list);
        String s0 = list.get(0);
        System.out.println(s0);
        //修改具体位置下标的值
        list.set(0,"PCB");
        System.out.println(list);
    }
}
